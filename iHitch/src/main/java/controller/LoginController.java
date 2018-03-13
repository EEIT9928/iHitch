package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.Member;
import model.service.MemberService;

@Controller
@RequestMapping(path = "/Login")
public class LoginController {

    @Autowired
	private MemberService ms;
    @RequestMapping(path= {"/login.controller"},method= {RequestMethod.POST})
	public String login (String email,String pswd,HttpSession session) {
		Member member = ms.login(email, pswd);
			if(member!=null){
				member.setPhoto(null);
				session.setAttribute("memberInfo", member);
				return "profile";
		}	
		return null;
	}

}
