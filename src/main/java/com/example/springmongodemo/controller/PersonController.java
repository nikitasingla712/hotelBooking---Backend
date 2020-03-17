package com.example.springmongodemo.controller;

import com.example.springmongodemo.model.Person;
import com.example.springmongodemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/create")
    public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address,@RequestParam String phone,@RequestParam String email,@RequestParam String pass,@RequestParam String passc) {
        Person p = personService.create(firstName, lastName, address,phone,email,pass,passc);
        return p.toString();
    }

    @RequestMapping("/get")
    public Person getPerson(@RequestParam String firstName) {
        return personService.findByFirstName(firstName);
    }
    @PostMapping("/create")

    @RequestMapping("/getAll")
    public List<Person> getAllPerson() {
        return personService.getAll();
    }

    @RequestMapping("/update")
    public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address,@RequestParam String phone,@RequestParam String email,@RequestParam String pass,@RequestParam String passc) {
        Person p = personService.update(firstName, lastName,address,phone,email,pass,passc);
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
