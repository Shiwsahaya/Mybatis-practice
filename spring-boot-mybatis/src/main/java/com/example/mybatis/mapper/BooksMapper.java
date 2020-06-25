package com.example.mybatis.mapper;

import com.example.mybatis.modal.Books;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface BooksMapper {

    @Select("select * from Books.Books")
    List<Books> findAll();

    @Insert("insert into Books.Books(name, price) values(#{name}, #{price})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
        before = false, resultType = Integer.class)
    void insert(Books books);

    @Update("update Books.Books set price=#{price}, name=#{name} where id=#{id}")
    void update(Books books);

    @Delete("delete from Books.Books where id=#{id}")
    void delete(Books books);
}
