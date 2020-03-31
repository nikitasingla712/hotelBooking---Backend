package com.example.springmongodemo.service;

import com.example.springmongodemo.model.Person;
import com.example.springmongodemo.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired                                                          // || IOC
    private PersonRepository personRepository;                          // private Class_Name Object_Name


    //CreateOperation
    public Person create(String firstName, String lastName, String address,String phone,String email,String pass,String passc) {
        //person = new Person(fn, ln, age)
        //.save(person)
        return personRepository.save(new Person(firstName, lastName, address,phone,email,pass,passc));         // .save(Object)
    }

    public String create(Person person) {
        personRepository.save(person);
        return ("Hi, " + person.getFirstName() + person.getLastName() + " you have been registered successfully!");
    }

    //RetrieveOperation
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    //UpdateOperation
    public Person update(String firstName, String lastName, String address,String phone,String email,String pass,String passc) {
        Person p = personRepository.findByEmail(email);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setAddress(address);
        p.setPhone(phone);
        p.setPass(pass);
        p.setPassc(passc);
        return personRepository.save(p);
    }

    //DeleteOperation
    public void deleteAll() {
        personRepository.deleteAll();
    }

    public void delete(String email) {
        Person p = personRepository.findByEmail(email);
        personRepository.delete(p);
    }
}
