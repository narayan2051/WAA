package com.miu.springbootproject.service;

import com.miu.springbootproject.model.Post;
import com.miu.springbootproject.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void save(User user);
    User getById(long id);
    List<User> findAll();
    List<Post> getPostsByUserId(long id);
    void deleteById(long id);
    List<User> findUserWhoHaveMoreThanOnePost();

    User findByUserName(String name);
}
