package dev.starichkov.java.spring.dao;

import dev.starichkov.java.spring.entities.User;

import java.util.Collection;

/**
 * @author Vadim Starichkov
 * @since 09.09.2016
 */
public interface UserDAO {

    User get(int id);

    void create(User user);

    void remove(int id);

    void update(User user);

    Collection<User> getAll();
}
