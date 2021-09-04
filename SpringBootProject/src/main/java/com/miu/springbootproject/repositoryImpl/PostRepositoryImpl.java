package com.miu.springbootproject.repositoryImpl;

import com.miu.springbootproject.model.Post;
import com.miu.springbootproject.repository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private List<Post> postList;

    public PostRepositoryImpl() {
       postList= new ArrayList<>();
       postList.add(new Post(1,"Clean Code","About Java Best Practises","Robert Martin"));
       postList.add(new Post(2,"Effective Java","Effective Java","Joshua Bloch"));
       postList.add(new Post(3,"Laravel","Up and Running","Mart Stauffer"));
       postList.add(new Post(4,"Full Stack React","Full Stack Developer in React","Anthony Accomazzo"));
       postList.add(new Post(5,"Learning PHP, MySql, JS, CSS & HTML","Learning PHP, MySql, JS, CSS & HTML","Robin"));
    }

    @Override
    public List<Post> getAll() {
        return postList;
    }

    @Override
    public Post getById(long id) {
        return postList.stream().filter(p->p.getId()==id).findFirst().orElse(null);
    }

}
