package com.digvijay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digvijay.entity.PANCard;

public interface IPANCardRepo extends JpaRepository<PANCard, Integer>{

}
