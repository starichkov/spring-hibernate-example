package org.starichkov.java.spring.service;

import org.springframework.beans.factory.annotation.Required;
import org.starichkov.java.spring.dao.UserDAOImpl;
import org.starichkov.java.spring.entities.User;

import java.util.Collection;

/**
 * @author Vadim Starichkov
 * @since 10.09.2016
 */
public class UserServiceImpl implements UserService {

    private UserDAOImpl userDAO;

    @Required
    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(User user) {
        userDAO.create(user);
    }

    public void updateUser(User user) {
        userDAO.create(user);
    }

    public Collection<User> listUsers() {
        return userDAO.getAll();
    }

    public User getUserById(int id) {
        return userDAO.get(id);
    }

    public void removeUser(int id) {

    }
}
