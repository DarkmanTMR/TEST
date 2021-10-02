package com.example.test.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"author"})
@NoArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Author> authors;
    private int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
