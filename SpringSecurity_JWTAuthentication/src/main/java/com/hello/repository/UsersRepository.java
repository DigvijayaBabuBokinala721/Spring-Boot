package com.hello.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	Optional<Users> findByUsername(String username);
	
}
