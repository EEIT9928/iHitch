package model.service;

import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Member;
import model.dao.superInterface.MemberDAO;
@Transactional
@Service
public class VerifyService {
	@Autowired
	MemberDAO mdao ;
//	============連線資訊==============
	private final String host =  "smtp.gmail.com";
	private final int port = 587;
	private final String username = "iHitchTest@gmail.com";  
	private final String password = "1921682173";

	public String SendEmail(String email) throws NoSuchAlgorithmException {
//		=====================加密======================
		int codex = (int)(Math.random()*100000000);
		String code = DigestUtils.sha1Hex(Integer.toString(codex));
//		=====================建立連結=====================
		StringBuffer sb= new StringBuffer();
			sb.append("點擊以下連結:");
		    sb.append("http://localhost:8080/iHitch/verify/getVerify.controller?email=");  
	        sb.append(email);   
	        sb.append("&verifyCode=");   
	        sb.append(code);  
//	    =====================eamil設定檔=================
	        Properties props = new Properties();  
	        props.put("mail.smtp.host", host);  
	        props.put("mail.smtp.auth", "true");  
	        props.put("mail.smtp.starttls.enable", "true");  
	        props.put("mail.smtp.port", port);  
//		============建立傳送訊息=================	=========	       
	        Session session = Session.getInstance(props,new Authenticator(){  
	              protected PasswordAuthentication getPasswordAuthentication() {  
	                  return new PasswordAuthentication(username, password);  
	              }} );  
	        
	        Message ms = new MimeMessage(session);
	        try {
				ms.setFrom(new InternetAddress(username));
				ms.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
//				============主旨==============
				ms.setSubject("testSubject");
//				============內容==============
				ms.setText(sb.toString());
				
				Transport ts = session.getTransport("smtp");
				ts.connect(host,port,username,password);
//				============傳送==============
				Transport.send(ms);
				return code;
	        }  catch (MessagingException e) {
				
				return null;
			}
	}	
	public Boolean CheckCode(int mid , String code1 ,String code2) {
		if(code1.equals(code2)) {
			Member member=mdao.select(mid);
			if(member.getCurrentLv()<=1) {
				member.setEmailVerified(true);
				member.setCurrentLv(2);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}
}
