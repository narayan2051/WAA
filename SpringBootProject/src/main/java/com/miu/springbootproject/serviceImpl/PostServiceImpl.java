package com.miu.springbootproject.serviceImpl;

import com.miu.springbootproject.model.Post;
import com.miu.springbootproject.model.PostV2;
import com.miu.springbootproject.repository.PostRepository;
import com.miu.springbootproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post getById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public boolean delete(long id) {
        postRepository.deleteById(id);
        return true;
    }

    @Override
    public void update(Post post, long id) {
        Post p1 = getById(id);
        p1.setAuthor(post.getAuthor());
        p1.setTitle(post.getTitle());
        p1.setContent(post.getContent());
        save(p1);
    }

    @Override
    public PostV2 getByIdV2(long id) {
        Post p = getById(id);
        return null == p ? null : new PostV2(p.getId(), p.getTitle(), p.getContent());
    }

}
