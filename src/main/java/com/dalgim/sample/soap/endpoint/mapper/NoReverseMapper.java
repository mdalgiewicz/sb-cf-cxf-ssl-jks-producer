package com.dalgim.sample.soap.endpoint.mapper;

/**
 * Created by Mateusz Dalgiewicz on 29.03.2017.
 */
public interface NoReverseMapper<K, E> {

    K map(E endpointModel);
}
