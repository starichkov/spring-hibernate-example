package org.starichkov.java.spring.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.starichkov.java.spring.entities.User;
import org.starichkov.java.spring.service.UserService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Vadim Starichkov
 * @since 09.09.2016
 */
@Controller
public class UsersViewController {

    private final UserService userService;

    @Autowired
    public UsersViewController(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        User jediObiWanKenobi = new User("Obi-Wan", "Kenobi");
        userService.addUser(jediObiWanKenobi);

        User sithDarthVader = new User("Darth", "Vader");
        userService.addUser(sithDarthVader);
    }

    @RequestMapping(value = "/")
    public ModelAndView getAllUsers() {
        Collection<String> tableHeaders = new ArrayList<>();
        tableHeaders.add("#");
        tableHeaders.add("First Name");
        tableHeaders.add("Last Name");

        Collection<User> users = userService.listUsers();

        // show users.jsp
        ModelAndView model = new ModelAndView("users");
        model.addObject("tableHeaders", tableHeaders);
        model.addObject("users", users);

        return model;
    }
}
