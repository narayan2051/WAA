package com.miu.springbootproject.controller;

import com.miu.springbootproject.model.Post;
import com.miu.springbootproject.model.PostV2;
import com.miu.springbootproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Rest controller to handle all posts related APIS
 * @author Narayan
 * @since 3 sept 2021
 */
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPost(){
        return postService.getAll();
    }

    @GetMapping("/v1/{id}")
    public Post getById(@PathVariable("id") long id){
        return postService.getById(id);
    }

    @PostMapping
    public Post save(@RequestBody Post post){
        return postService.save(post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
       return postService.delete(id)?new ResponseEntity<>(HttpStatus.ACCEPTED):new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody Post post,@PathVariable("id") long id){
        postService.update(post,id);
    }

    @GetMapping("/hat/{id}")
    public EntityModel<Post> getByIdHat(@PathVariable("id")long id){
        Post p= postService.getById(id);
        EntityModel<Post> res= EntityModel.of(p);
        WebMvcLinkBuilder postLink= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(getClass()).save(new Post()));
        WebMvcLinkBuilder deleteLink= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(getClass()).delete(id));
        res.add(postLink.withRel("save-api"));
        res.add(deleteLink.withRel("delete-api"));
        return res;
    }

    @GetMapping(value = "/v2/{id}")
    public PostV2 getByIdV2(@PathVariable("id") long id){
       return postService.getByIdV2(id);
    }
}
