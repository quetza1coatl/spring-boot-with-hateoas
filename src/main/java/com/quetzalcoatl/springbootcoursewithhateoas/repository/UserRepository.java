package com.quetzalcoatl.springbootcoursewithhateoas.repository;

import com.quetzalcoatl.springbootcoursewithhateoas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
