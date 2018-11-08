package com.lch.it.person.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lch.it.person.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}