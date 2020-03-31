package com.example.springmongodemo.repository;

import com.example.springmongodemo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
     Person findByEmail(String email);

    default List<Person> findByFirstName(String firstName) {
        return null;
    }

}
