package com.gens.task2.repository;

import org.springframework.stereotype.Repository;

import com.gens.task2.entities.User;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO{

	@Override
	public void inserOrUpdateItem(User user) {
		super.inserOrUpdateItem(user);
		
	}

	@Override
	public void deleteItem(User user) {
		super.deleteItem(user);
	}

	@Override
	public void deleteByID(int id) {
		super.deleteByID(id);
		
	}

	@Override
	public User retrieveByID(int id) {
		return super.retrieveByID(id);
	}

	@Override
	public User selectByUserName(String username) {
		User us1 = null;
		String JPQL = "SELECT a FROM User a WHERE a.userName = :userName";
		try{
			us1 = (User) entityManager.createQuery(JPQL).setParameter("userName", username).getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return us1;
	}

}
