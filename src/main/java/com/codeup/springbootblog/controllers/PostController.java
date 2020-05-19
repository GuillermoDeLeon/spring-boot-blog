package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.*;
import com.codeup.springbootblog.repositories.PostRepository;
import com.codeup.springbootblog.repositories.UserRepository;

import com.codeup.springbootblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

//    private final PostRepository postDao;
    private UserRepository userDao;
    private PostRepository postDao;
    private EmailService emailService;

    public PostController(UserRepository userDao, PostRepository postDao, EmailService emailService) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.emailService = emailService;
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

    @GetMapping("/posts/create")
    public String createPost(Model model) {
        User user = userDao.getOne(1L);
        Post post = new Post();
        post.setUser(user);
        model.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitCreatePost(@ModelAttribute Post post) {
//        User author = userDao.getOne(1L);
        User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(author.getEmail());
        post.setUser(author);
        post = postDao.save(post);
        emailService.prepareAndSend(post,"You have created a new post",
                "Your post \""+post.getTitle()+
                        "\" was successfully created.\nYou can see it at http://localhost:8080/posts/"+post.getId()+"\nThank you.");
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Post post = postDao.getOne(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts/editcreate")
    public String editCreatePost(Model model) {
        User user = userDao.getOne(1L);
        Post post = new Post();
        post.setUser(user);
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @GetMapping("/posts/test")
    public String goToTestPage() {
        return "posts/test";
    }
}


