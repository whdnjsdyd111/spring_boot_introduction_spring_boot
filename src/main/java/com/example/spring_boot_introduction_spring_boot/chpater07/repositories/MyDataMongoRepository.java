package com.example.spring_boot_introduction_spring_boot.chpater07.repositories;

import com.example.spring_boot_introduction_spring_boot.chpater07.MyDataMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyDataMongoRepository extends MongoRepository<MyDataMongo, Long> {

}
