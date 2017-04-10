package com.dalgim.sample.soap.mapper;

import com.dalgim.sample.soap.entity.AbstractEntity;

/**
 * Created by Mateusz Dalgiewicz on 25.03.2017.
 */
public interface ObjectMapper<T, E extends AbstractEntity> {

    T map(E e);
    E reverseMap(T t);
}
