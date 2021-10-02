package com.example.test.Controllers;

import com.example.test.Models.Author;
import com.example.test.Models.Book;
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
        List<Book> books = bookDAO.findAll();
        return books;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id){
        return bookDAO.findById(id).get();
    }

    @PatchMapping
    public Book updateBook(@RequestBody Book bookFromRequest){
        Book bookFromDB = bookDAO.getById(bookFromRequest.getId());
        return bookDAO.save(bookFromRequest);
             }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        bookDAO.deleteById(id);
    }

    @GetMapping("/{id}/authors")
    public List<Author> getBooksAuthors(@PathVariable int id){
        List<Author> authors = bookDAO.findById(id).get().getAuthors();
        return authors;
    }

}
