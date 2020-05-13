package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Override
    List<Post> findAll();

}
