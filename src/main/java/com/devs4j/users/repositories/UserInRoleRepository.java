package com.devs4j.users.repositories;

import com.devs4j.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devs4j.users.entities.UserInRole;

import java.util.List;

@Repository
public interface UserInRoleRepository extends JpaRepository<UserInRole, Integer> {

    List<UserInRole> findByUser(User user);

    @Query("SELECT ur.user FROM UserInRole ur WHERE ur.role.name = :roleName")
	List<User> findByUsersByRoleName(@Param("roleName") String roleName);
}
