package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.Member;
import model.bean.PassDetail;
import model.service.ShowBookService;

@Controller
@RequestMapping(path= {"/ShowBooked"})
public class ShowBookedControlle {

@Autowired
private	ShowBookService sbs;

@ResponseBody
@RequestMapping(path= {"/showAll.controller"},method = { RequestMethod.GET }, produces = { "application/json" })
public List<PassDetail> showAll(HttpSession session){
		Member memberInfo = (Member) session.getAttribute("memberInfo");
		if(memberInfo !=null) {
			List<PassDetail>passDetails= sbs.showAllBooked(memberInfo.getMid());
			return passDetails;
		}else {return null;}
		
	}
}
