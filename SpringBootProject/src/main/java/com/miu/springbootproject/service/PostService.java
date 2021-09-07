package com.miu.springbootproject.service;

import com.miu.springbootproject.model.Post;
import com.miu.springbootproject.model.PostV2;

import java.util.List;

public interface PostService {
    List<Post> getAll();

    Post getById(long id);

    Post save(Post post);

    boolean delete(long id);

    void update(Post post, long id);

    PostV2 getByIdV2(long id);
}
