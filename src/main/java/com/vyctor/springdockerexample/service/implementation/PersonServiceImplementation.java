package com.vyctor.springdockerexample.service.implementation;

import com.vyctor.springdockerexample.entity.Person;
import com.vyctor.springdockerexample.model.PersonDto;
import com.vyctor.springdockerexample.repository.PersonJpaRepository;
import com.vyctor.springdockerexample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PersonServiceImplementation implements PersonService {
    @Autowired
    private PersonJpaRepository personJpaRepository;

    @Override
    public Person save(PersonDto personDto) {
        Person tobeSaved = new Person(personDto);
        return personJpaRepository.save(tobeSaved);
    }

    @Override
    public Person update(PersonDto personDto) {
        Person toBeSaved = getById(personDto.getId());
        if (Objects.nonNull(personDto.getAge())) {
            toBeSaved.setName(personDto.getName());
        }
        if (Objects.nonNull((personDto.getAge()))) {
            toBeSaved.setAge(personDto.getAge());
        }
        return personJpaRepository.save(toBeSaved);
    }

    @Override
    public Person getById(Long id) {
        return personJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No person found with the data id"));
    }

    @Override
    public void deleteById(Long id) {
        personJpaRepository.deleteById(id);
    }
}
