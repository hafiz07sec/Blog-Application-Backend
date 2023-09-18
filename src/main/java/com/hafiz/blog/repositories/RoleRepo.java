package com.hafiz.blog.repositories;

import com.hafiz.blog.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
