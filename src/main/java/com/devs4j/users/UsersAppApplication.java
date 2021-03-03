package com.devs4j.users;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devs4j.users.entities.Role;
import com.devs4j.users.entities.User;
import com.devs4j.users.entities.UserInRole;
import com.devs4j.users.repositories.RoleRepository;
import com.devs4j.users.repositories.UserInRoleRepository;
import com.devs4j.users.repositories.UserRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class UsersAppApplication implements ApplicationRunner {
	
    private static final Logger log = LoggerFactory.getLogger(UsersAppApplication.class);
	
	@Autowired
	private Faker faker;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserInRoleRepository userInRoleRepository;

	public static void main(String[] args) {
		SpringApplication.run(UsersAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Role roles[] = { new Role("ADMIN"), new Role("SUPPORT"), new Role("USER") };

		for (Role role : roles) {
			this.roleRepository.save(role);
		}

		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setUserName(faker.name().username());
			user.setPassword(faker.dragonBall().character());
			user.setProfile(null);
			this.userRepository.save(user);

			UserInRole userInRole = new UserInRole(user, roles[new Random().nextInt(3)]);
			userInRoleRepository.save(userInRole);
			
			log.info("Username {} Password {} Role {}", user.getUserName(), user.getPassword(), userInRole.getRole().getName());
		}
	}

}
