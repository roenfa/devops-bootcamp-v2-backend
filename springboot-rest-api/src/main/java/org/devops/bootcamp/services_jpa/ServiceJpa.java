package org.devops.bootcamp.services_jpa;

import java.util.List;
import java.util.NoSuchElementException;

public interface ServiceJpa<S> {
    List<S> findAll();
    
    S getById(long id) throws NoSuchElementException;

    S save(S s);

    void deleteById(long id);
}
