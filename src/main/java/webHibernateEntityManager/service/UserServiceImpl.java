package webHibernateEntityManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webHibernateEntityManager.dao.UserDaoImpl;
import webHibernateEntityManager.model.User;

import java.util.List;

@Service
public class UserServiceImpl {

    private final UserDaoImpl userDao;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public void delete(long id) {
        userDao.delete(id);
    }

    public void add(User user) {
        userDao.add(user);
    }

    public User edit(User user) {
        return userDao.edit(user);
    }

    public User findById(long id) {
        return userDao.findById(id);
    }
}
