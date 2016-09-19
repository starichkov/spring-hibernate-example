package org.starichkov.java.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.starichkov.java.spring.dao.UserDAOImpl;
import org.starichkov.java.spring.entities.User;

import java.util.Collection;

/**
 * @author Vadim Starichkov
 * @since 09.09.2016
 */
public class MainTest {
    /*
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/app.xml");
        UserDAOImpl userDAO = context.getBean(UserDAOImpl.class);
//        printUsers(userDAO);
//        User person = new User("Obi-Wan", "Kenobi");
//        userDAO.create(person);
//        System.out.println("User: " + person);
        printUsers(userDAO);
        context.close();
    }

    private static void printUsers(UserDAOImpl userDAO) {
        Collection<User> list = userDAO.getAll();
        System.out.println("Users:");
        for (User user : list) {
            System.out.println(user);
        }
    }
    */
}
