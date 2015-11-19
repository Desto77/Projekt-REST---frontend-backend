package com.gft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gft.model.UserDAO;
import com.gft.service.DatabaseService;

@Controller
@RequestMapping("/rest")
public class RestController {
//	@Autowired
//	private UsersService usersService;
	
	@Autowired
	private DatabaseService databaseService;

	// ==== GET ALL USERS ====//
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<UserDAO> getAllUsers() {
		System.out.println("GET");
		return databaseService.findAll();
	}

	// ==== DELETE USER BY ID ====//
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void removeUser(@PathVariable String id) {
		System.out.println("DELETE");
		databaseService.delete(Integer.parseInt(id));
	}

	// ==== ADD USER====//
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.OK)
	public void addUser(@RequestBody String body) {
		System.out.println("PUT");
		databaseService.addUser(body);
	}
	
//	// ==== GET ALL USERS ====//
//	@RequestMapping(value = "/users", method = RequestMethod.GET)
//	public @ResponseBody List<User> getAllUsers() {
//		System.out.println("GET");
//		return usersService.getAllUsers();
//	}
//
//	// ==== DELETE USER BY ID ====//
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//	@ResponseStatus(value = HttpStatus.OK)
//	public void removeUser(@PathVariable String id) {
//		System.out.println("DELETE");
//		usersService.removeUser(Long.parseLong(id));
//	}
//
//	// ==== ADD USER====//
//	@RequestMapping(value = "/add", method = RequestMethod.PUT)
//	@ResponseStatus(value = HttpStatus.OK)
//	public void addUser(@RequestBody String body) {
//		System.out.println("PUT");
//		usersService.addUser(body);
//	}

}
