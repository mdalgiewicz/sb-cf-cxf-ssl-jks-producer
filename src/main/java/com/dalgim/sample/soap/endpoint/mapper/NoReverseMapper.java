package com.dalgim.sample.soap.endpoint.mapper;

/**
 * Created by dalgim on 29.03.2017.
 */
public interface NoReverseMapper<K, E> {

    K map(E endpointModel);
}
