package com.miu.springbootproject.serviceImpl;

import com.miu.springbootproject.model.Post;
import com.miu.springbootproject.repository.PostRepository;
import com.miu.springbootproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    @Override
    public Post getById(long id) {
        return postRepository.getById(id);
    }
}
