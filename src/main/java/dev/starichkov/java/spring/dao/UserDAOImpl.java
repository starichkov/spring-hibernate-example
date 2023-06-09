package dev.starichkov.java.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import dev.starichkov.java.spring.entities.User;

import java.util.Collection;
import java.util.List;

/**
 * @author Vadim Starichkov
 * @since 09.09.2016
 */
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User get(int id) {
        User user;
        Session session = sessionFactory.openSession();
        user = session.find(User.class, id);
        session.close();
        return user;
    }

    public void create(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }

    public void remove(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(get(id));
        transaction.commit();
        session.close();
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public Collection<User> getAll() {
        Session session = sessionFactory.openSession();
        List<User> personList = session.createQuery("from User", User.class).list();
        session.close();
        return personList;
    }
}
