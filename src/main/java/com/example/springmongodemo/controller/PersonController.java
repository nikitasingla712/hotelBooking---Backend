package com.example.springmongodemo.controller;

import com.example.springmongodemo.model.Person;
import com.example.springmongodemo.repository.PersonRepository;
import com.example.springmongodemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController                          //Create the class as RESTful APi
@CrossOrigin(origins = "*")             //CORS
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address, @RequestParam String phone,@RequestParam String email,@RequestParam String pass,@RequestParam String passc) {
        Person p = personService.create(firstName, lastName, address,phone,email,pass,passc);
        return p.toString();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(@RequestBody Person person) {
        personService.create(person);
        return ("Hi, " + person.getFirstName() + " " + person.getLastName() + " you have been registered successfully!");
    }

    @RequestMapping("/get")
    public Person getPerson(@RequestParam String email) {
        return personService.findByEmail(email);
    }

    @RequestMapping("/getAll")
    public List<Person> getAllPerson() {
        return personService.getAll();
    }

    @RequestMapping("/update")
    public String update(@RequestParam String firstName, @RequestParam String lastName,@RequestParam String address, @RequestParam String phone,@RequestParam String email,@RequestParam String pass,@RequestParam String passc) {
        Person p = personService.update(firstName, lastName, address,phone,email,pass,passc);
        return p.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName) {
        personService.delete(firstName);
        return "Deleted " + firstName;
    }

    @RequestMapping("/deleteAll")
    public String deleteAll() {
        personService.deleteAll();
        return "Deleted All Records!";
    }
}
