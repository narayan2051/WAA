package com.miu.springbootproject.repository;

import com.miu.springbootproject.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();
    Post findById(long id);
}
