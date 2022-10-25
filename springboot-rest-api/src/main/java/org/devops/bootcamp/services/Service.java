package org.devops.bootcamp.services;

import java.util.List;

public interface Service<S>{
    List<S> getAll();

    S getById(int id);

    S insert(S p);

    S update(int id, S p);

    S delete(int id);
}
