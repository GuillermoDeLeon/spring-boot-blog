package com.codeup.springbootblog.models;

//import jdk.jfr.Category;
//import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ads")
public class Ad{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    String title;

    @Column
    String description;

    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ad")
    private List<AdImage> images;

    @ManyToMany(mappedBy = "ads")
    private List<Category> categories;

    public Ad() {
    }

    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<AdImage> getImages() {
        return images;
    }

    public void setImages(List<AdImage> images) {
        this.images = images;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
