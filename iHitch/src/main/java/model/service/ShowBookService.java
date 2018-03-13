package model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.PassDetail;
import model.dao.superInterface.PassDetailDAO;

@Transactional
@Service
public class ShowBookService {
@Autowired
private PassDetailDAO PDD;

	public List<PassDetail> showAllBooked(int mid) {
		List<PassDetail> details = PDD.selectMemberDeatails(mid);
		if(details!=null) {
			return details;
		}
		return null;	
	}

}
