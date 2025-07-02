package com.hello.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hello.document.License;

public interface ILicenseRepo extends MongoRepository<License, String>{

}
