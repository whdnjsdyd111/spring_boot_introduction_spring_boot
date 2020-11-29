package com.example.spring_boot_introduction_spring_boot.chpater07.repositories;

import com.example.spring_boot_introduction_spring_boot.chpater07.MyDataMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MyDataMongoRepository08 extends MongoRepository<MyDataMongo, Long> {
    public List<MyDataMongo> findByName(String s);
}
