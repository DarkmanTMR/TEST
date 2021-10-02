package com.example.test.dao;

import com.example.test.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book, Integer> {
}
