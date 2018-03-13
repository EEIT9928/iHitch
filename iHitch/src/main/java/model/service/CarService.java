package model.service;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Car;
import model.bean.Member;
import model.dao.superInterface.CarDAO;

@Transactional
@Service
public class CarService {
	@Autowired
	private CarDAO cardao;

	public Car selectCar(Member bean) {
		return cardao.select(bean.getMid());

	}
	public Car selectCar(Integer carId) {
		return cardao.select(carId);

	}

	public Car selectCarByNo(String carNo) {
		return cardao.select(carNo);

	}

	public Integer insertCar(Car bean) {
		return cardao.insert(bean);

	}

	public Car updateCar(Car bean) {
		return cardao.update(bean);
	}

	public boolean deleteCar(Car bean) {
		return cardao.delete(bean.getCarId());
	}

	public List<Car> selectMemberCars(Member memberInfo) {
		return cardao.selectMemberCars(memberInfo.getMid());
	}

	public boolean checkCar(Integer carId) {
		Car car = cardao.select(carId);
		if (car != null) {
			return true;
		}
			return false;
	}
	public boolean uploadCarPhoto(Blob blob ,Integer carId) {
		Car car=cardao.select(carId);
		if(car!=null) {
			car.setCarDocPhoto(blob);
			return true;
		}return false;
	}
}
