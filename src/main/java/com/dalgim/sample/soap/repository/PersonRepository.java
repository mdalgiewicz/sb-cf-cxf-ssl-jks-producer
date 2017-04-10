package com.dalgim.sample.soap.repository;

import com.dalgim.sample.soap.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mateusz Dalgiewicz on 25.03.2017.
 */
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

    PersonEntity findByLogin(String login);

}
