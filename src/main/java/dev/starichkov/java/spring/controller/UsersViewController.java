package dev.starichkov.java.spring.controller;

import jakarta.annotation.PostConstruct;

import dev.starichkov.java.spring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import dev.starichkov.java.spring.service.UserService;

import java.util.Collection;
import java.util.List;

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

    @GetMapping("/")
    public String getAllUsers(Model model) {
        Collection<User> users = userService.listUsers();

        model.addAttribute("tableHeaders", List.of("#", "First Name", "Last Name"));
        model.addAttribute("users", users);

        return "users";
    }
}
