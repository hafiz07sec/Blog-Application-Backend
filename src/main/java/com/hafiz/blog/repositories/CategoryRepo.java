package com.hafiz.blog.repositories;

import com.hafiz.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer > {
}
