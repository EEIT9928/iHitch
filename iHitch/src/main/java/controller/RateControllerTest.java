package controller;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.bean.Member;
import model.bean.Rate;
import model.service.RateServiceTest;

@RestController
@RequestMapping("/Ratings")
public class RateControllerTest {

	@Autowired
	RateServiceTest rateService;

	//GetMemberPhoto
	@RequestMapping(path = { "/Photos" }, method = RequestMethod.GET, produces = { "image/*" })
	@ResponseBody
	public byte[] getChatPhoto(@RequestParam("Mid") Integer Mid){
		Member bean = rateService.getMember(Mid);
		Blob photo = bean.getPhoto();
		try {
			return IOUtils.toByteArray(photo.getBinaryStream());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(path = "/Left/{mId}.controller", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public HashMap<String, List> getLeftRatings(@PathVariable("mId") Integer mId, HttpSession session) {
		return rateService.getLeftRatings(mId);
	}

	@RequestMapping(path = "/Received/{mId}.controller", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public HashMap<String, List> getReceivedRatings(@PathVariable("mId") Integer mId) {
		return rateService.getReceivedRatings(mId);
	}

	@RequestMapping(method = { RequestMethod.POST }, produces = { "application/json" })
	@ResponseBody
	public HashMap<String, String> rateMember(@RequestBody Rate bean) {
		HashMap<String, String> msg = new HashMap<String, String>();

		if (bean != null) {
			System.out.println(bean);
			if (bean.getRideId() == null || bean.getRideId() % 2 != 1) {
				// Log 非法Request
				msg.put("ride", "rideIdeErr");
			}
			if ((bean.getFromMid() == null || bean.getFromMid() % 2 != 0)
					|| (bean.getToMid() == null || bean.getToMid() % 2 != 0)) {
				// Log 非法Request
				msg.put("Mid", "MidErr");
			}
			if (bean.getStar() == null || bean.getStar() < 1 && 5 < bean.getStar()) {
				msg.put("star", "Must have Rating");
			}
			if (bean.getComment() != null && bean.getComment().length() > Math.pow(2, 31) - 1) {
				// 超過 varchar(max) Limit
				msg.put("comment", "Commemt too long");
			}
			if (!msg.isEmpty()) {
				msg.put("rate", "Rate Fail");
				return msg;
			}
			if (rateService.rateMember(bean)) {
				msg.put("rate", "Rate Success");
				return msg;
			} else {
				// Log 非法Request
				msg.put("data", "Illegal data");
			}
		} else {
			// Log 非法Request
			msg.put("bean", "bean is null");
		}
		msg.put("rate", "Rate Fail");
		return msg;
	}
	// 取得資料
	// 轉換資料
	// 驗證資料

	// Controller(前端只送五項資料)
	// 資料格式
	// member*2 ---偶數(2) not null
	// ride ---基數(1) not null
	// star ---整數1~5 not null
	// comment ---length < 2^31-1

	// Service
	// Rate條件
	// ride ---存在DB
	// Now < rideDate+rideTime+7day ---Rate功能使用期限
	// member*2 ---存在DB &&
	// 對象正確(ride or passDetail 記載之member)
	// check Rate isExist = null ---禁止重複Rate
	// Exist標準 >> member*2,ride 一致
	// 追加rateDate ---用DB預設可解決跨時區問題(懶的話)

	// 呼叫服務
	// 回傳結果
}
