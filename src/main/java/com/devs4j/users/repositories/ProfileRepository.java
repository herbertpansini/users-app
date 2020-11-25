package com.devs4j.users.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devs4j.users.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	@Query("SELECT p FROM Profile WHERE p.user.id=?1 AND id=?2")
	Optional<Profile> findByUserIdAndProfileId(Integer userId, Integer profileId);
}
