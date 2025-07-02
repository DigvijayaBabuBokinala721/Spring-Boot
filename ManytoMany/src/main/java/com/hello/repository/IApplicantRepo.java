package com.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.entity.Applicant;

public interface IApplicantRepo extends JpaRepository<Applicant, Integer> {

}
