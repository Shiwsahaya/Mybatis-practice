package com.example.mybatis.controller;

import com.example.mybatis.mapper.BooksMapper;
import com.example.mybatis.modal.Books;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private BooksMapper booksMapper;
    private Books books;

    public BooksController(BooksMapper booksMapper, Books books) {
        this.booksMapper = booksMapper;
        this.books = books;
    }

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
        private String update(@RequestParam int id, @RequestParam(value = "price", defaultValue = "0") int price,
                              @RequestParam(value = "name", defaultValue = "name") String name) {
            System.out.println(name);

        books.setId(id);

        if(price!= 0)
            books.setPrice(price);

        if(!name.equals("name"))
            books.setName(name);

        booksMapper.update(books);

        return "updated successful";
        }


        @DeleteMapping("/delete")
        private String delete(@RequestParam int  id) {
        books.setId(id);
        booksMapper.delete(books);
        return "deleted successful";
        }

}
