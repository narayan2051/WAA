package com.miu.springbootproject.serviceImpl;

import com.miu.springbootproject.model.Post;
import com.miu.springbootproject.model.Role;
import com.miu.springbootproject.model.User;
import com.miu.springbootproject.repository.UserRepository;
import com.miu.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Post> getPostsByUserId(long id) {
       // return userRepository.findPostsByUserId(id);
        return null;
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findUserWhoHaveMoreThanOnePost() {
        return userRepository.findUserWhoHaveMoreThanOnePost();
    }

    @Override
    public User findByUserName(String name) {
        return userRepository.findByUsername(name);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = getByUserName(s);
        List<GrantedAuthority> authorities= new ArrayList<>();

        for(Role role: user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
       return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
               authorities);
    }

    private User getByUserName(String s) {
        return userRepository.findByUsername(s);
    }
}
