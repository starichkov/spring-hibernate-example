package dev.starichkov.java.spring.service;

import dev.starichkov.java.spring.entities.User;

import java.util.Collection;

/**
 * @author Vadim Starichkov
 * @since 10.09.2016
 */
public interface UserService {

    void addUser(User p);

    void updateUser(User p);

    Collection<User> listUsers();

    User getUserById(int id);

    void removeUser(int id);
}
