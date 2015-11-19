package com.gft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gft.model.UserDAO;
import com.gft.model.UserDetailsDAO;
import com.gft.service.DatabaseService;

@Controller
public class UsersController {

	@Autowired
	private DatabaseService databaseService;
	// ==== TESTING WITH HUPERNATE ====//

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void testHibernate() {
		System.out.println("Testing...");
		UserDetailsDAO details = new UserDetailsDAO("Fajna 9", "Lodz", 513559659);
		UserDAO user = new UserDAO("Grzegorz", "Flemming", 26, details);
		databaseService.save(user);
		databaseService.findAll();
		//System.out.println(databaseService.findAll().toString());
	}

	// @Autowired
	// private UsersService usersService;
	//
	// // ==== INIT ====//
	// @RequestMapping(value = "/init", method = RequestMethod.GET)
	// public String initUsers() {
	// System.out.println("Initializing...");
	// usersService.initUsers();
	// return "redirect:/users";
	// }
	//
	// // ==== GET ALL USERS ====//
	// @RequestMapping(value = "/users", method = RequestMethod.GET)
	// public String displayAllUsers(HttpServletRequest request) {
	// request.setAttribute("users", usersService.getAllUsers());
	// return "users";
	// }
	//
	// // ==== DELETE USER BY ID ====//
	// @RequestMapping(value = "/users", method = RequestMethod.POST)
	// public String removeUser(HttpServletRequest request) {
	// usersService.removeUser(Long.parseLong(request.getParameter("remove")));
	// return "redirect:/users";
	// }
	//
	// // ==== REDIRECT TO ADD USER ====//
	// @RequestMapping(value = "/add-user", method = RequestMethod.GET)
	// public String redirectToAddUser() {
	// return "addUser";
	// }
	//
	// // ==== ADD USER ====//
	// @RequestMapping(value = "/add-user", method = RequestMethod.POST)
	// public String addUser(HttpServletRequest request) {
	// usersService.addUser(request.getParameter("firstName"),
	// request.getParameter("lastName"),
	// Integer.parseInt(request.getParameter("age")));
	// return "redirect:/users";
	// }
}
