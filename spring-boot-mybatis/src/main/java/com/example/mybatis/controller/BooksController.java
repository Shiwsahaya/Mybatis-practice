package com.example.mybatis.controller;

import com.example.mybatis.mapper.BooksMapper;
import com.example.mybatis.modal.Books;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {


    private BooksMapper booksMapper;

    public BooksController(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @GetMapping("/all")
    public List<Books> getAll() {
        return booksMapper.findAll();
    }

    @GetMapping("/insert")
    private List<Books> add() {
        Books books = new Books();
        books.setName("DS");
        books.setPrice(1200);
        booksMapper.insert(books);

        return booksMapper.findAll();
    }

        @GetMapping("/update")
        private List<Books> update() {
        Books books = new Books();
        books.setName("DS");
        books.setPrice(500);

        booksMapper.update(books);
        return booksMapper.findAll();
        }

        @GetMapping("/delete")
        private List<Books> delete() {
        Books books = new Books();
        books.setName("DS");

        booksMapper.delete(books);
        return booksMapper.findAll();
        }

}
