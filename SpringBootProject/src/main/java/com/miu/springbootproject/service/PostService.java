package com.miu.springbootproject.service;

import com.miu.springbootproject.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll();
    Post getById(long id);
}
