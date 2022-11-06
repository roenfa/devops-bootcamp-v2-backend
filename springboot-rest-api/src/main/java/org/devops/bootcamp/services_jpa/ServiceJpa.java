package org.devops.bootcamp.services_jpa;

import java.util.List;
import java.util.NoSuchElementException;

import org.devops.bootcamp.exceptions.InternalServerErrorException;

public interface ServiceJpa<S> {
    List<S> findAll();
    
    S getById(long id) throws NoSuchElementException;

    S save(S s);

    void deleteById(long id) throws InternalServerErrorException;
}
