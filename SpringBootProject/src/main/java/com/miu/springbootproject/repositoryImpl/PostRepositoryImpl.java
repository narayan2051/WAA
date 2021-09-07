package com.miu.springbootproject.repositoryImpl;

import com.miu.springbootproject.model.Post;
import com.miu.springbootproject.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



public class PostRepositoryImpl {
//
//    private final List<Post> postList;
//
//    public PostRepositoryImpl() {
//        postList = new ArrayList<>();
//        postList.add(new Post(1, "Clean Code", "About Java Best Practises", "Robert Martin"));
//        postList.add(new Post(2, "Effective Java", "Effective Java", "Joshua Bloch"));
//        postList.add(new Post(3, "Laravel", "Up and Running", "Mart Stauffer"));
//        postList.add(new Post(4, "Full Stack React", "Full Stack Developer in React", "Anthony Accomazzo"));
//        postList.add(new Post(5, "Learning PHP, MySql, JS, CSS & HTML", "Learning PHP, MySql, JS, CSS & HTML", "Robin"));
//    }
//
//    @Override
//    public List<Post> getAll() {
//        return postList;
//    }
//
//    @Override
//    public Post getById(long id) {
//        return postList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
//    }
//
//    @Override
//    public Post save(Post post) {
//        if (post.getId() != 0) {
//            post.setId(postList.size() + 1);
//        }
//        postList.add(post);
//        return post;
//    }
//
//    @Override
//    public boolean delete(long id) {
//        return postList.remove(getById(id));
//    }
//
//    @Override
//    public void update(Post post, long id) {
//        postList.stream().filter(p -> p.getId() == id).map(p -> {
//            p.setTitle(post.getTitle());
//            p.setContent(post.getContent());
//            p.setAuthor(post.getAuthor());
//            return p;
//        });
//    }
}
