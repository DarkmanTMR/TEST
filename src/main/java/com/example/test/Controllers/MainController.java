package com.example.test.Controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    public static void main(String[] args) {

    }
}



//реализовываем следующий функционал:
//Книжный магазин
//Entities:
//Book (id,title, Author[],price)
//Author (id,name,surname, Book[])
//CRUD на все сущности.
//Страницы
//Всех книг, одной книги, авторы данной книги
//Все авторы, один автор, книги данного автора
//В качестве фронта - реакт или ангулар. дизайн не важен.
//Бонусом будет реализация поиска всего (книги, автора) через инпут путем ввода слова или его части