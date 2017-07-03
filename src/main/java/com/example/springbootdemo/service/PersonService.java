package com.example.springbootdemo.service;

import com.example.springbootdemo.repository.PersonRepository;
import com.example.springbootdemo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhaoqicheng on 2017/3/23.
 */

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void addTwoPerson() {
        Person p1 = new Person();
        p1.setId(5);
        p1.setName("john");
        p1.setWork("dancer");
        this.personRepository.save(p1);

        Person p2 = new Person();
        p2.setId(6);
        p2.setName("john2");
        p2.setWork("dancer2");
        this.personRepository.save(p2);

    }
}
