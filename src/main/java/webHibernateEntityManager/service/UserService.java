package webHibernateEntityManager.service;

import webHibernateEntityManager.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void delete(long id);

    void add(User user);

    User edit(User user);

    User findById(long id);
}
