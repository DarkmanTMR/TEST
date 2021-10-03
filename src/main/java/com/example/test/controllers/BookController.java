package com.example.test.controllers;

import com.example.test.model.Author;
import com.example.test.model.Book;
import com.example.test.dao.BookDAO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/books")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})

public class BookController {
    private BookDAO bookDAO;

    @PostMapping
    private Book saveBook(@RequestBody Book book){
        return bookDAO.save(book);

    }
    @GetMapping
    public List<Book> allBooks(){
        return bookDAO.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id){
        return bookDAO.findById(id).orElse(new Book("Java",100500));
    }

    @PatchMapping
    public Book updateBook(@RequestBody Book bookFromRequest) {
        Book bookFromDB = bookDAO.getById(bookFromRequest.getId());
        return bookDAO.save(bookFromDB);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        bookDAO.deleteById(id);
    }

    @GetMapping("/{id}/authors")
    public List<Author> getBooksAuthors(@PathVariable int id){
        return bookDAO.findById(id).get().getAuthors();
    }

}
