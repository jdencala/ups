package com.example.ups.poo.bootstrap;

import com.example.ups.poo.entity.Person;
import com.example.ups.poo.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PersonRepository personRepository;

    public BootStrapData(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person();
        p1.setName("Jorge");
        p1.setLastname("Encalada");
        p1.setAge(29);
        p1.setPersonId("0925849622");

        Person p2 = new Person();
        p2.setName("Sandy");
        p2.setLastname("Medina");
        p2.setAge(32);
        p2.setPersonId("0929069151");

        personRepository.save(p1);
        personRepository.save(p2);

        System.out.println("----------- Started BootStrapData");
        System.out.println("Number of Person: " + personRepository.count());
    }
}
