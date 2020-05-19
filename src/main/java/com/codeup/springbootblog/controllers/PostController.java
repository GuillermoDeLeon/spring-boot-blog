package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.*;
import com.codeup.springbootblog.repositories.PostRepository;
import com.codeup.springbootblog.repositories.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

//    private final PostRepository postDao;
    private UserRepository userDao;
    private PostRepository postDao;

    public PostController(UserRepository userDao, PostRepository postDao) {
        this.userDao = userDao;
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String showPostsIndexPage(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showAnIndividualPost(@PathVariable long id, Model model) {
        Post thisPost = postDao.getOne(id);
        model.addAttribute("post", thisPost);
            return "posts/show";
    }

//    @GetMapping("/posts/create")
//    public String createPost() {
//        return "posts/create;
//    }

    @PostMapping("/posts/create")
    public String submitCreatePosts(@RequestParam String title, @RequestParam String body) {
        User author = userDao.getOne(1L);
        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setBody(body);

        newPost.setUser(author);
        postDao.save(newPost);
        return "redirect:/posts";
    }

    @GetMapping("/posts/test")
    public String goToTestPage() {
        return "posts/test";
    }
}


