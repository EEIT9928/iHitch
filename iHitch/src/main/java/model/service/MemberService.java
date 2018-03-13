package model.service;

import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Member;
import model.dao.superInterface.MemberDAO;
@Transactional
@Service
public class MemberService {
	@Autowired
	private MemberDAO mDAO;
	
	public Member login( String email , String pswd) {
		Member member = mDAO.select(email);
		if(member!=null) {
			if(member.getPwd().equals(pswd)) {
				return member;
			}
		}
		return null;
	}
	public Member chgPswd(Member memberInfo,String newPswd) {
		Member member = mDAO.select(memberInfo.getMid());
		if(member!=null) {
		member.setPwd(newPswd);
		return member;
		}
		return member;
	}
	
	public Member editProfile(Member memberInfo,Member bean) {
		Member member =  mDAO.select(memberInfo.getMid());
		if(member !=null) {
			member.setBirthYear(bean.getBirthYear());
			member.setCountry(bean.getCountry());
			member.setFirstName(bean.getFirstName());
			member.setLastName(bean.getLastName());
			member.setPhone(bean.getPhone());
			member.setGender(bean.getGender());
			member.setBio(bean.getBio());
			return member;
		}
		return member;
	}
	
	public Member editPaRefrence(Member memberInfo,Member bean) {
		Member member = mDAO.select(memberInfo.getMid());
		if(	member !=null) {
			member.setPrefPaMusic(bean.getPrefPaMusic());
			member.setPrefPaPet(bean.getPrefPaPet());
			member.setPrefPaSmoke(bean.getPrefPaSmoke());
			member.setPrefPaTalk(bean.getPrefPaTalk());
			return member;}
		else {
			return null;}

	}
	public Member editDrRefrence(Member memberInfo,Member bean) {
		Member member = mDAO.select(memberInfo.getMid());
		if(member !=null) {
		member.setPrefDrMusic(bean.getPrefDrMusic());
		member.setPrefDrPet(bean.getPrefDrPet());
		member.setPrefDrSmoke(bean.getPrefDrSmoke());
		member.setPrefDrTalk(bean.getPrefDrTalk());
		return member	;}	
		else {
			return null;}
	}
	 public Member showMemberInfo(Member memberInfo) {
		return mDAO.select(memberInfo.getMid());
	 }
	public Member editPhoto(Member memberInfo,Blob photo) {
		Member mb = mDAO.select(memberInfo.getMid());
		mb.setPhoto(photo);
		return mb;
	}
	public Member editLicense(Member memberInfo,Blob photo) {
		Member mb = mDAO.select(memberInfo.getMid());
		if(mb!=null) {
			mb.setLicensePhoto(photo);
		}else {
			return mb;
		}
		return mb;
	}
	public Blob getPhoto(int mid ) {
		return mDAO.select(mid).getPhoto();
	}
	public Member getMemberInfo(int mid) {
		return mDAO.select(mid);
	}

}
