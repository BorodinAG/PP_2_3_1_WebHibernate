package webHibernateEntityManager.dao;

import webHibernateEntityManager.model.User;

import javax.persistence.Id;
import java.util.List;

public interface UserDao {
    List<User> getAll();

    void delete(long id);

    void add(User user);

    User edit(User user);

    User findById(long id);
}
