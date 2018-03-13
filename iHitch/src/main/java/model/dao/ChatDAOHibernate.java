package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Chat;
import model.dao.superInterface.ChatDAO;

@Repository
public class ChatDAOHibernate implements ChatDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public Chat select(int id) {
		return this.getSession().get(Chat.class, id);
	}

	@Override
	public List<Chat> select() {
		return this.getSession().createQuery("FROM Chat", Chat.class).list();
	}

	@Override
	public Integer insert(Chat bean) {
		if (bean != null) {
			return (Integer) this.getSession().save(bean);
		}
		return null;
	}

	@Override
	public Chat update(Chat bean) {
		if (bean != null) {
			Chat result = this.getSession().get(Chat.class, bean.getChatId());
			if (result != null) {
				result.setFromMid(bean.getFromMid());
				result.setToMid(bean.getToMid());
				result.setChatDateTime(bean.getChatDateTime());
				result.setContent(bean.getContent());
				result.setPhoto(bean.getPhoto());
				result.setIsRead(bean.getIsRead());
			}
			return result;
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		Chat temp = this.getSession().get(Chat.class, id);
		if (temp != null) {
			this.getSession().delete(temp);
			return true;
		}
		return false;
	}
}
