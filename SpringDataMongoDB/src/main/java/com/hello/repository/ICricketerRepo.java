package com.hello.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hello.document.Cricketer;

public interface ICricketerRepo extends MongoRepository<Cricketer, String> {

}
