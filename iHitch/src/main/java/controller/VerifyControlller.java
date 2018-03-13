package controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import model.bean.Member;
import model.service.VerifyService;
import model.service.MemberService;

@Controller
@RequestMapping(path= {"/verify"})
public class VerifyControlller {
	@Autowired
	VerifyService es;
	@Autowired
	MemberService ms;
	
	@ResponseBody
	@RequestMapping(path= {"/getcode.controller"},method= {RequestMethod.GET},produces= {"application/json"})
	public Map<String, String> getEmailVerifyCode(String email,HttpSession session){
		Map<String, String> map = new HashMap<>();
		try {
			String code = es.SendEmail(email);
			session.setAttribute("code", code);
			map.put("msg", "請確認信箱信件");
		} catch (NoSuchAlgorithmException e) {
			map.put("er", "寄送失敗");
		}
		return map;}
	@ResponseBody
	@RequestMapping(path= {"/getVerify.controller"},method= {RequestMethod.POST,RequestMethod.GET},produces= {"application/json"})
	public Map<String, String> getVerify (String email,String verifyCode,HttpSession session){
		Map<String, String> map = new HashMap<>();
		Member memberInfo = (Member) session.getAttribute("memberInfo");
		if(memberInfo!=null) { 
			String code = (String) session.getAttribute("code");
			session.setAttribute("code", null);
			if(code!=null) {
				if(es.CheckCode(memberInfo.getMid(), code,verifyCode)) {
				Member member =	ms.showMemberInfo(memberInfo);
				session.setAttribute("memberInfo", member);
					map.put("msg", "乘客驗證成功");
				}else {
					map.put("er", "已經驗證過了");
				}
				return map;
			}else {
				map.put("er", "再試一次");
			}
			return map;
		}else {
			return null;}	
	}
}
