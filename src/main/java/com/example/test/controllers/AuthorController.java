package com.example.test.controllers;

import com.example.test.dao.AuthorDAO;
import com.example.test.model.Author;
import com.example.test.model.Book;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/authors")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})

public class AuthorController {
    private AuthorDAO authorDAO;


    @PostMapping
    private Author saveAuthor(@RequestBody Author author){
        System.out.println(author);
        return authorDAO.save(author);
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable int id){
        return  authorDAO.findById(id).orElse(new Author("John","Snow"));
    }

    @GetMapping
    public List<Author> allAuthors(){
       return authorDAO.findAll();
    }


    @PatchMapping
    public Author updateAuthor(@RequestBody Author authorFromRequest){
        Author authorFromDB = authorDAO.getById(authorFromRequest.getId());
        return  authorDAO.save(authorFromDB);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        authorDAO.deleteById(id);
    }

    @GetMapping("/{id}/books")
    public List<Book> getAuthorsBooks(@PathVariable int id){
        return authorDAO.findById(id).get().getBooks();

    }
}

