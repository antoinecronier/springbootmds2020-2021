package com.tactfactory.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.demo.entities.User;
import com.tactfactory.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return this.repository.findAll();
	}

//	public void save(User user) {
//		this.repository.save(user);
//	}

	public void generateUsers(final Integer nb) {
		for (int i = 0; i < nb; i++) {
			User user = new User();
			user.setFirstname("fname"+i);
			user.setLastname("Lname"+i);

			this.repository.save(user);
		}
	}
}
