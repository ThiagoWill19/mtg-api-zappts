package com.mtg.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtg.api.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsById(int id);
	
	boolean existsByName(String name);
	
	User findByName(String name);
}
