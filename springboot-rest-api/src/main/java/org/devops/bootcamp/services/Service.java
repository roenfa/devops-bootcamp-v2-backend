package org.devops.bootcamp.services;

import java.util.List;

public interface Service<S>{
    List<S> getAll();

    S getById(int id);

    S insert(S p);

    void update(int id, S p);

    void delete(int id);
}
