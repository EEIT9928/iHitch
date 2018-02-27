package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Rate;
import model.dao.superInterface.RateDAO;

@Repository
public class RateDAOHibernate implements RateDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Rate select(int id) {
		return this.getSession().get(Rate.class, id);
	}

	@Override
	public List<Rate> select() {
		return this.getSession().createQuery("FROM Rate", Rate.class).list();
	}

	@Override
	public Integer insert(Rate bean) {
		if (bean != null) {
			return (Integer) this.getSession().save(bean);
		}
		return null;
	}

	@Override
	public Rate update(Rate bean) {
		if (bean != null) {
			Rate result = this.getSession().get(Rate.class, bean.getRateId());
			if (result != null) {
				result.setFromMid(bean.getFromMid());
				result.setToMid(bean.getToMid());
				result.setStar(bean.getStar());
				result.setComment(bean.getComment());
				result.setRateDate(bean.getRateDate());
				result.setRideId(bean.getRideId());
			}
			return result;
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		Rate temp = this.getSession().get(Rate.class, id);
		if (temp != null) {
			this.getSession().delete(temp);
			return true;
		}
		return false;
	}
}
