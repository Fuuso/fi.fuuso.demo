package fi.fuuso.demo.dao;

import java.io.Serializable;

import org.hibernate.Query;

public interface AbstractDAO<T, ID extends Serializable> {

	public void store(T entity);
	public T selectOne(Query query);
	
}
