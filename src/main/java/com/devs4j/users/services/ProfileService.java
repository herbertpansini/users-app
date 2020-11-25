package com.devs4j.users.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.entities.Profile;
import com.devs4j.users.entities.User;
import com.devs4j.users.repositories.ProfileRepository;
import com.devs4j.users.repositories.UserRepository;

@Service
@Transactional
public class ProfileService {
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Profile getByUserIdAndProfileId(Integer userId, Integer profileId) {
		return this.profileRepository.findByUserIdAndProfileId(userId, profileId)
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile not found for user %d and profile %d", userId, profileId)));
	}
	
	public Profile create(Integer userId, Profile profile) {
		Optional<User> result = this.userRepository.findById(userId);
		if (result.isPresent()) {
			profile.setUser(result.get());
			return this.profileRepository.save(profile);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found!", userId));
		}
	}
}