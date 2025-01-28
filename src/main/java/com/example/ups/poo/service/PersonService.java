package com.example.ups.poo.service;

import com.example.ups.poo.dto.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    List<Person> personList = new ArrayList<>();

    public List<Person> getAllPeople() {
        Person p1 = new Person();
        p1.setName("Jorge");
        p1.setLastname("Encalada");
        p1.setAge(29);
        p1.setId("0925849622");

        Person p2 = new Person("Sandy", "Medina", 32, "0929069542");

        personList.add(p1);
        personList.add(p2);
        return personList;
    }
}
