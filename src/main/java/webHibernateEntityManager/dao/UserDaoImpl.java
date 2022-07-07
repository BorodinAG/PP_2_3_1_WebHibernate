package webHibernateEntityManager.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import webHibernateEntityManager.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return entityManager.createQuery("select a from User a", User.class).getResultList();
    }

    @Transactional
    public void delete(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Transactional
    public void add(User addUser) {
        entityManager.persist(addUser);

    }

    @Transactional
    public User edit(User editUser) {
        return entityManager.merge(editUser);
    }

    @Transactional
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }
}
