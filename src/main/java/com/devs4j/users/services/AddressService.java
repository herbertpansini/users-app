package com.devs4j.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.entities.Address;
import com.devs4j.users.entities.Profile;
import com.devs4j.users.repositories.AddressRepository;
import com.devs4j.users.repositories.ProfileRepository;

@Service
@Transactional
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ProfileRepository profileRepository;

	public List<Address> findAddressesByProfileAndUserId(Integer userId, Integer profileId) {
		return this.addressRepository.findByProfileId(userId, profileId);
	}

	public Address createAddress(Integer userId, Integer profileId, Address address) {
		Optional<Profile> result = this.profileRepository.findByUserIdAndProfileId(userId, profileId);
		if (result.isPresent()) {
			address.setProfile(result.get());
			return this.addressRepository.save(address);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Profile %d and User %d not found!", profileId, userId));
		}
	}
}
