package com.dalgim.sample.soap.endpoint.model;

/**
 * Created by dalgim on 29.03.2017.
 */
public interface EndpointObjectInMapper<E, K> {

    K map(E endpointModel);
}
