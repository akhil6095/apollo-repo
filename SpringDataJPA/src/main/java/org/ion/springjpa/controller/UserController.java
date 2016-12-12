package org.ion.springjpa.controller;

import org.ion.springjpa.domain.User;
import org.ion.springjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody User saveUser(@RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/user/{firstName}", method = RequestMethod.GET)
	public @ResponseBody List<User> getUserByFirstName(@PathVariable String firstName) {
		return userService.get(firstName);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAll();
	}

	@RequestMapping(value = "/firstNames", method = RequestMethod.GET)
	public @ResponseBody List<String> getUsersFirstName() {
		return userService.getFirstNames();
	}

	@RequestMapping(value = "/oldestUser", method = RequestMethod.GET)
	public @ResponseBody User getOldestUser() {
		return userService.getOldestUser();
	}
}
