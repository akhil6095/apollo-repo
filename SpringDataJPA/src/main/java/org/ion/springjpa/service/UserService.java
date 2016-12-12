package org.ion.springjpa.service;

import org.ion.springjpa.domain.User;
import org.ion.springjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	public List<User> get(String firstName) {
		return userRepository.findByFirstName(firstName);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public List<String> getFirstNames() {
		return userRepository.getListOfFirstNames();
	}

	public User getOldestUser() {
		return userRepository.findTopByOrderByAgeDesc();
	}

	public Stream<User> getUserStream() {
		return userRepository.getUserAsStream();
	}

}
