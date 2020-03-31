package com.example.springmongodemo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
    @Id
    String id;

    String firstName, lastName,address,phone,email,pass,passc;


    public Person(String firstName, String lastName, String address,String phone,String email,String pass,String passc) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.pass = pass;
        this.passc = passc;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassc() {
        return passc;
    }
    public void setPassc(String passc) {
        this.passc = passc;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", UID ='" + address + '\''+
                ", Phone ='" + phone + '\'' +
                ", E-mail ='" + email + '\'' +
                ", Password ='" + pass + '\'' +
                ", Confirm Password ='" + passc + '\'' +
                '}';
    }
}