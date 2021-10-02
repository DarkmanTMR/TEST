package com.example.test.dao;

import com.example.test.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDAO extends JpaRepository<Author, Integer> {
}
