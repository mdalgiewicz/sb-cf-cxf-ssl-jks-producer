package com.dalgim.sample.soap.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;

/**
 * Created by dalgim on 25.03.2017.
 */
@Getter
@Setter
@Builder
@Entity
public class PersonEntity extends AbstractEntity {

    private String login;
    private String password;
    private String firstname;
    private String lastname;
}
