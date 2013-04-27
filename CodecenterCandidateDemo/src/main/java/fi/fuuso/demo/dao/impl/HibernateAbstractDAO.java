package fi.fuuso.demo.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;

import fi.fuuso.demo.dao.AbstractDAO;
import fi.fuuso.demo.utils.HibernateUtil;

public class HibernateAbstractDAO<T, ID extends Serializable> implements AbstractDAO<T, Serializable> {

	protected Session getSession() {
		return HibernateUtil.getSession();
	}
	
	public void store(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.save(entity);
	}

	public T selectOne(Query query) {
        T t;
        t = (T) query.uniqueResult();
        return t;
	}

}
