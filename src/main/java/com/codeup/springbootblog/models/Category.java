package com.codeup.springbootblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ads_categories",
            joinColumns = {@JoinColumn(name="category_id")},
            inverseJoinColumns = {@JoinColumn(name="ad_id")}
    )
    private List<Ad> ads;

}
