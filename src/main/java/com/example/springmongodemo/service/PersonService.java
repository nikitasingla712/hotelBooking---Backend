package com.example.springmongodemo.service;

import com.example.springmongodemo.model.Person;
import com.example.springmongodemo.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    //CreateOperation
    public Person create(String firstName, String lastName, String address,String phone,String email,String pass,String passc) {
        return personRepository.save(new Person(firstName, lastName, address,phone,email,pass,passc));
    }

    //RetrieveOperation
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person findByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    //UpdateOperation
    public Person update(String firstName, String lastName, String address,String phone,String email,String pass,String passc) {
        Person p = personRepository.findByFirstName(firstName);
        p.setLastName(lastName);
        p.setAddress(address);
        p.setPhone(phone);
        p.setEmail(email);
        p.setPass(pass);
        p.setPassc(passc);
        return personRepository.save(p);
    }

    //DeleteOperation
    public void deleteAll() {
        personRepository.deleteAll();
    }

    public void delete(String firstName) {
        Person p = personRepository.findByFirstName(firstName);
        personRepository.delete(p);
    }
}
