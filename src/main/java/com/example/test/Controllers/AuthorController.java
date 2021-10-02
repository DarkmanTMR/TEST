package com.example.test.Controllers;

import com.example.test.Models.Author;

import com.example.test.Models.Book;
import com.example.test.dao.AuthorDAO;
import com.example.test.dao.BookDAO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/authors")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})

public class AuthorController {
    private AuthorDAO authorDAO;
    private BookDAO bookDAO;

    @PostMapping
    private Author saveAuthor(@RequestBody Author author){
        System.out.println(author);
        return authorDAO.save(author);
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable int id){
        return  authorDAO.findById(id).get();
    }

    @GetMapping
    public List<Author> allAuthors(){
        List<Author> authors = authorDAO.findAll();
        return authors;
    }


    @PatchMapping
    public Author updateAuthor(@RequestBody Author authorFromRequest){
        Author authorFromDB = authorDAO.getById(authorFromRequest.getId());
        return  authorDAO.save(authorFromRequest);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        authorDAO.deleteById(id);
    }

    @GetMapping("/{id}/books")
    public List<Book> getAuthorsBooks(@PathVariable int id){
        List<Book> books = authorDAO.findById(id).get().getBooks();
        return books;
    }
}

