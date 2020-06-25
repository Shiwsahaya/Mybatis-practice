package com.example.mybatis.mapper;

import com.example.mybatis.modal.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface BookMapper {

    @Select("select * from users")
    List<Book> findAll();
}
