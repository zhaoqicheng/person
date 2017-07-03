package com.example.springbootdemo.repository;

import com.example.springbootdemo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhaoqicheng on 2017/3/23.
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
