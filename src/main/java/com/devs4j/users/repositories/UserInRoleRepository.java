package com.devs4j.users.repositories;

import com.devs4j.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.users.entities.UserInRole;

import java.util.List;

@Repository
public interface UserInRoleRepository extends JpaRepository<UserInRole, Integer> {

    List<UserInRole> findByUser(User user);
}
