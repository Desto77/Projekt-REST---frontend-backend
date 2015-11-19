package com.gft.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.gft.model.UserDAO;

@Repository
public class UserRepository {

	@PersistenceContext
	private EntityManager em;

	public UserDAO findById(Integer userId) {
		return em.find(UserDAO.class, userId);
	}
	
	public List<UserDAO> findAll() {
		return em.createQuery("SELECT u FROM UserDAO u").getResultList();
							 // "SELECT u FROM UserDAO u JOIN u.details where u.id = 'Europe'
	
	}
	
	public UserDAO create(UserDAO user) {
		System.out.println("CREATE");
		System.out.println(user.toString());
		em.persist(user);
		return user;
	}
	
	public UserDAO update(UserDAO user) {
		return em.merge(user);
	}
	
	public void delete(Integer id) {
		UserDAO toRemove = findById(id);
		if (toRemove == null) {
			throw new RuntimeException("Cant find user with given id: " + id);
		}
		em.remove(toRemove);
	}
}
