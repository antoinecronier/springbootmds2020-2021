package com.tactfactory.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tactfactory.demo.entities.User;
import com.tactfactory.demo.services.UserService;

@Controller
@RequestMapping(UserController.BASE_ROUTE)
public class UserController extends BaseCrudController<User> {

	public static final String TEMPLATE_NAME = "user";
	public static final String BASE_ROUTE = "user";

	public UserController() {
		super(TEMPLATE_NAME);
	}

	@Autowired
	private UserService service;

	@GetMapping("testgen")
	public void testGen() {
		this.service.generateUsers(20);
	}
}
