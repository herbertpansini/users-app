package com.devs4j.users.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.devs4j.users.entities.Role;
import com.devs4j.users.repositories.RoleRepository;


@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getRoles() {
		return this.roleRepository.findAll();
	}
	
	public Role getRoleById(Integer id) {
		Optional<Role> result = this.roleRepository.findById(id);
		if (result.isPresent()) {
			return result.orElse(null);
		} else {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, String.format("Role id $d doesn't exists", id));
		}
	}
	
	public Role createRole(Role role) {
		return this.roleRepository.save(role);
	}
	
	public Role updateRole(Integer id, Role role) {
		Optional<Role> result = this.roleRepository.findById(id);
		if (result.isPresent()) {
			return this.roleRepository.save(role);
		} else {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, String.format("Role id $d doesn't exists", id));
		}
	}
	
	public void deleteRole(Integer id) {
		Optional<Role> result = this.roleRepository.findById(id);
		if (result.isPresent()) {
			this.roleRepository.deleteById(id);
		} else {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, String.format("Role id $d doesn't exists", id));
		}
	}
}
