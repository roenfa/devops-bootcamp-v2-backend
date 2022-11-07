package org.devops.bootcamp.repositories;

import java.util.List;

public interface Repository<T, ID> {
    T save(T entity);
    T delete(T entity);
    List<T> getAll();
    T getById(ID entityId);
}
