package com.dalgim.sample.soap.endpoint.mapper;

/**
 * Created by dalgim on 29.03.2017.
 */
public interface EndpointObjectOutMapper<E, K> {

    E map(K domainModel);
}
