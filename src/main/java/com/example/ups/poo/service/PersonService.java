package com.example.ups.poo.service;

import com.example.ups.poo.dto.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    List<Person> personList = new ArrayList<>();

    public ResponseEntity getAllPeople() {
        if(personList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person list is empty");
        }
        return ResponseEntity.status(HttpStatus.OK).body(personList);
    }

    public ResponseEntity getPersonById(String id) {
        for(Person person: personList) {
            if(id.equalsIgnoreCase(person.getId())) {
                return ResponseEntity.status(HttpStatus.OK).body(person);
            }
        }
        String message = "Person with id: "+id + " not found";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    public ResponseEntity createPerson(Person person) {
        personList.add(person);
        return ResponseEntity.status(HttpStatus.OK).body("Person successfully registered");
    }

    public ResponseEntity updatePerson(Person person){
        for(Person per: personList){
            if(per.getId().equalsIgnoreCase(person.getId())) {
               per.setName(person.getName());
               per.setLastname(person.getLastname());
               per.setAge(person.getAge());
               return ResponseEntity.status(HttpStatus.OK)
                       .body("Person with id: " + person.getId() + " was successfully updated");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Person with id: " + person.getId() + " not found");
    }

}
