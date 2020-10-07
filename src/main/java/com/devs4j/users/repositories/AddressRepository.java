package com.devs4j.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devs4j.users.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}