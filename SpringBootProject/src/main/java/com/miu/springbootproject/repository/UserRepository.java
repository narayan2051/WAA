package com.miu.springbootproject.repository;

import com.miu.springbootproject.model.Post;
import com.miu.springbootproject.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
   @Query("SELECT u FROM User u WHERE u.id>:id")
    List<User> findPostsByUserId(@Param("id") long id);
    @Query("SELECT u FROM User u WHERE u.roles.size>1")
    List<User> findUserWhoHaveMoreThanOnePost();

    User findByUsername(String name);

}
