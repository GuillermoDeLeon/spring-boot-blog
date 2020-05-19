package com.codeup.springbootblog.models;

import javax.persistence.*;

@Entity
@Table(name = "ad_images")
public class AdImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String path;

    @ManyToOne
    @JoinColumn(name="ad_id")
    private Ad ad;

    public AdImage() {}

    public AdImage(String path, Ad ad) {
        this.path = path;
        this.ad = ad;
    }

    public AdImage(long id, String path, Ad ad) {
        this.id = id;
        this.path = path;
        this.ad = ad;
    }
}
