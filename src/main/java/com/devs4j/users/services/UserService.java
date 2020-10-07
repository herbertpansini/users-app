package com.devs4j.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.entities.User;
import com.devs4j.users.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Page<User> getUsers(int page, int size) {
		return this.userRepository.findAll(PageRequest.of(page, size));
	}

	public User getUserById(Integer id) {
		return this.userRepository.findById(id).orElse(null);
	}
	
	public User getUserByUsername(String username) {
		return this.userRepository.findByUsername(username).orElse(null);
	}
	
	public User getUserByUsernameByPassword(String username, String password) {
		return this.userRepository.findByUsernameAndPassword(username, password).orElseThrow(()-> new ResponseStatusException(HttpStatus.NO_CONTENT, String.format("User %s not found", username)));
	}
}
