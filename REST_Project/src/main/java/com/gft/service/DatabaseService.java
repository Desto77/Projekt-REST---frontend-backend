package com.gft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gft.model.UserDAO;
import com.gft.repository.UserRepository;
import com.google.gson.Gson;

@Service
public class DatabaseService {

	@Autowired
	private UserRepository userRepository;

	@Transactional(readOnly = true)
	public List<UserDAO> findAll() {
		return userRepository.findAll();
	}
	
	public UserDAO findById(int userId) {
		return userRepository.findById(userId);
	}
	
	@Transactional
	public UserDAO save(UserDAO user) {
		if (user.getId() == null) {
			System.out.println("creating");
			return userRepository.create(user);
		} else {
			System.out.println("updating");
			return userRepository.update(user);
		}
	}
	
	@Transactional
	public void addUser(String data) {
		Gson gson = new Gson();
		UserDAO tempUser = gson.fromJson(data, UserDAO.class);
		tempUser.setId(null);
		save(tempUser);
	}
	
	
	
	@Transactional
	public void delete(Integer id) {
		userRepository.delete(id);
	}

}



	

	

	