package model.dao.superInterface;

import java.util.List;

import org.hibernate.Session;

import model.bean.Rate;

public interface RateDAO {

	Session getSession();

	Rate select(int id);

	List<Rate> select();

	Integer insert(Rate bean);

	Rate update(Rate bean);

	boolean delete(int id);

}