package model.dao.superInterface;

import java.util.List;

import org.hibernate.Session;

import model.bean.Chat;

public interface ChatDAO {

	Session getSession();

	Chat select(int id);

	List<Chat> select();

	Integer insert(Chat bean);

	Chat update(Chat bean);

	boolean delete(int id);

}