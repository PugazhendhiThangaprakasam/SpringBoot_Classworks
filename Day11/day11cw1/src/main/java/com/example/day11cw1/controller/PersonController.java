package com.example.day11cw1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day11cw1.model.Person;
import com.example.day11cw1.service.PersonService;

@RestController
public class PersonController {
    public PersonService personService;
    public PersonController(PersonService personService)
    {
        this.personService = personService;
    }
    @PostMapping("/person")
    public ResponseEntity<Person> postMethodName(@RequestBody Person person) {
        if(personService.savePerson(person))
        {
            return new ResponseEntity<>(person,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/person")
    public ResponseEntity<List<Person>> getMethodName() {
        List<Person> list = personService.getPersons();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/person/{personId}")
    public ResponseEntity<Person> getMethod(@PathVariable("personId") long id) {
        Person p = personService.getPersonById(id);
        if(p==null)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
}
