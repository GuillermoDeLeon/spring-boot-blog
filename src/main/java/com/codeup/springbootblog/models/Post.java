package com.codeup.springbootblog.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
//    @NotBlank(message = "Posts need a title")
    private String title;

    @Column(columnDefinition = "TEXT")
//    @NotBlank(message = "Posts need a body")
//    @Size(min = 2, message = "body should have at least 2 characters or more")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post() {}

    public Post (String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(String title, String body, User user, long id) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
