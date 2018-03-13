package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.Member;
import model.bean.Ride;
import model.service.ShowOfferedService;

@Controller
@RequestMapping(path= {"/ShowOffer"})
public class ShowOfferedController {
	@Autowired
	private	ShowOfferedService sos;
	
	@ResponseBody
	@RequestMapping(path= {"/ShowAll.controller"},method= {RequestMethod.GET},produces= {"application/json"})
	public List<Ride> showAll(HttpSession session){
		Member memberInfo = (Member) session.getAttribute("memberInfo");
		if(memberInfo !=null) {
			List<Ride>rides= sos.selectAllRide(memberInfo.getMid());
			return rides;
		}else {return null;}
	

	}
}
