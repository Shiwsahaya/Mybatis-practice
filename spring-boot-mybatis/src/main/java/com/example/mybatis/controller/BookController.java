package com.example.mybatis.controller;

import com.example.mybatis.mapper.BookMapper;
import com.example.mybatis.modal.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {


    private BookMapper bookMapper;

    public BookController(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @GetMapping("/all")
    public List<Book> getAll() {
        return bookMapper.findAll();
    }
}
