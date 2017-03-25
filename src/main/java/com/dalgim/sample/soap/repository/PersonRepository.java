package com.dalgim.sample.soap.repository;

import com.dalgim.sample.soap.model.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dalgim on 25.03.2017.
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByLogin(String login);

}
