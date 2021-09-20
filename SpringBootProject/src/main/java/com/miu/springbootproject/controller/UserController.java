package com.miu.springbootproject.controller;

import com.miu.springbootproject.model.Post;
import com.miu.springbootproject.model.User;
import com.miu.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable("id") long id) {
        return userService.getPostsByUserId(id);
    }

    @GetMapping("/more-than-one-post")
    public List<User> getMoreThanOnePostUser() {
        return userService.findUserWhoHaveMoreThanOnePost();
    }

    @GetMapping("/loggedInUser")
    public String getLoggedInUser(Authentication authentication) {
        System.out.println("========>"+authentication.getName());
        return authentication.getName();
    }
}
