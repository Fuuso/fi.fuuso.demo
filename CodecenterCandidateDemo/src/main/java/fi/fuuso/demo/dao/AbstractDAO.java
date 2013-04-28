package fi.fuuso.demo.dao;

import java.io.Serializable;

public interface AbstractDAO<T, ID extends Serializable> {

	public void store(T entity);
	
}
