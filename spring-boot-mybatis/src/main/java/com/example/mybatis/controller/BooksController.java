package com.example.mybatis.controller;

import com.example.mybatis.mapper.BooksMapper;
import com.example.mybatis.modal.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BooksMapper booksMapper;

    @GetMapping("/all")
    public List<Books> getAll() {
        return booksMapper.findAll();
    }

    @PostMapping("/add")
    private String saveData(@RequestBody Books books) {
        booksMapper.insert(books);
        return "inserted successful";
    }

    @PutMapping("/update")
    private String update(@RequestParam int id, @RequestBody Books books) {

        books.setId(id);
        booksMapper.update(books);

        return "updated successful";
    }

        @DeleteMapping("/delete/{id}")
        private String delete(@PathVariable int  id) {

        booksMapper.delete(id);

        return "deleted successful";
        }

}
