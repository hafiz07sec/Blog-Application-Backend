package com.hafiz.blog.repositories;

import com.hafiz.blog.entities.Category;
import com.hafiz.blog.entities.Post;
import com.hafiz.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    List<Post> findByTitleContaining(String title);
}
