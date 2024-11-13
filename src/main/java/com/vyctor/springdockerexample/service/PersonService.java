package com.vyctor.springdockerexample.service;

import com.vyctor.springdockerexample.entity.Person;
import com.vyctor.springdockerexample.model.PersonDto;

public interface PersonService {
    Person save(PersonDto personDto);
    Person update(PersonDto personDto);
    Person getById(Long id);
    void deleteById(Long id);
}
