package com.gens.task2.repository;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public interface GenericDAO<I extends Serializable, E extends Serializable>{
	
	
	@NotNull
	List<I> retrieveAll();
	
	void inserOrUpdateItem(@NotNull I entity);
	void deleteItem(@NotNull I entity);
	void deleteByID(@NotNull E id);
	I retrieveByID(@NotNull E id);





}
