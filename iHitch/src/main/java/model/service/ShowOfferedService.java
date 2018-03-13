package model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Ride;
import model.dao.superInterface.RideDAO;
@Transactional
@Service
public class ShowOfferedService {
	@Autowired
	private RideDAO rd ;

	public List<Ride> selectAllRide(int id) {
		return rd.selectByDrId(id);
	}
}
