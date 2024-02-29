package com.example.day11cw1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day11cw1.model.Person;
import com.example.day11cw1.repository.PersonRepository;

@Service
public class PersonService {
    public PersonRepository personRepository;
    public PersonService(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }
    public boolean savePerson(Person person)
    {
        try
        {
            personRepository.save(person);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Person> getPersons()
    {
        return personRepository.findAll();
    }
    public Person getPersonById(long id)
    {
        return personRepository.findById(id).orElse(null);
    }
}
