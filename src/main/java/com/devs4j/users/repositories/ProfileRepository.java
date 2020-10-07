package com.devs4j.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.users.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
