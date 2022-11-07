package org.devops.bootcamp.services;

import org.devops.bootcamp.models.User;
import org.devops.bootcamp.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class UserServiceImpl implements Service<User> {

    @Autowired
    private IUserRepository IUserRepository;

    @Override
    public List<User> getAll() {
        return IUserRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return IUserRepository.getById(id);
    }

    @Override
    public User insert(User p) {
        return IUserRepository.save(p);
    }

    @Override
    public User update(int id, User p) {
        return IUserRepository.update(p.getName(), p.getEmail(), p.getPassword(), id);
    }

    @Override
    public void delete(int id) {
        IUserRepository.deleteById(id);
    }

    public User getByName(String name) {
        return IUserRepository.getByName(name);
    }
}
