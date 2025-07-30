package com.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Integer>{

}
