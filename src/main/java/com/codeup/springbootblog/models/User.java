package com.codeup.springbootblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Ad> ads;


}


