package com.rest.users.services;

import java.io.Serializable;
import java.util.List;

public interface ServiceOperations<E> {
	
	E save(E entity);

	E getById(Serializable id);

	List<E> getAll();
	
	void delete(Serializable id);
}
