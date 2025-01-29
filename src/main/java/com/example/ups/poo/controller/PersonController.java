package com.example.ups.poo.controller;

import com.example.ups.poo.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/get-all-people")
    public ResponseEntity getAllPeople() {
        //Get All People registered in App.
        return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPeople());
    }

    @GetMapping("/get-person")
    public ResponseEntity getObjectByPersonId(@RequestParam String id){
        //This method finds a person by comparing id sent in RequestParam.
        return personService.getPersonById(id);
    }
}
