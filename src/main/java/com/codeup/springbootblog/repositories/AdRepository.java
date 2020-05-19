package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {
}
