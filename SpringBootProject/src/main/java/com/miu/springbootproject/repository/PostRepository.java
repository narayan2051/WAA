package com.miu.springbootproject.repository;

import com.miu.springbootproject.model.Post;

import java.util.List;

public interface PostRepository {
    List<Post> getAll();
    Post getById(long id);
}
