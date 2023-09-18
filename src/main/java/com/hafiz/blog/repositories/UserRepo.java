package com.hafiz.blog.repositories;

import com.hafiz.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User>findByEmail(String userName);
}
