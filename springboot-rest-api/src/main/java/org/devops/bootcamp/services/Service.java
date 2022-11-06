package org.devops.bootcamp.services;

import org.devops.bootcamp.exceptions.NoSuchElementFoundException;

import java.util.List;

public interface Service<S>{
    List<S> getAll();

    S getById(int id) throws NoSuchElementFoundException;

    S insert(S p);

    void update(int id, S p);

    void delete(int id);
}
