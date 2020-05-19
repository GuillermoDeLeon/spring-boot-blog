package com.codeup.springbootblog.repositories;

import com.codeup.springbootblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
