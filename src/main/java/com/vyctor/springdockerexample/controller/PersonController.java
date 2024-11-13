package com.vyctor.springdockerexample.controller;

import com.vyctor.springdockerexample.entity.Person;
import com.vyctor.springdockerexample.model.PersonDto;
import com.vyctor.springdockerexample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/api/person/{id}")
    public PersonDto getPersonById(@PathVariable("id") Long id) {
        Person person = personService.getById(id);
        return new PersonDto(person);
    }

    @PostMapping("/api/person")
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        Person person = personService.save(personDto);
        return new PersonDto(person);
    }

    @PutMapping("/api/person")
    public PersonDto updatePerson(@RequestBody PersonDto personDto) {
        Person person = personService.update(personDto);
        return new PersonDto(person);
    }

    @DeleteMapping("/api/person/{id}")
    public void deletePersonById(@PathVariable("id") Long id) {
        personService.deleteById(id);
    }
}
