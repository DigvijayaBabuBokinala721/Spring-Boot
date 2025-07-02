package com.hello.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.entity.Application;

public interface IApplicationRepo extends JpaRepository<Application, Integer> {

	public Optional<Application> findByTitle(String title);
	
}
