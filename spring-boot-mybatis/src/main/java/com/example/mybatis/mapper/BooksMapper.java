package com.example.mybatis.mapper;

import com.example.mybatis.modal.Books;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

@Mapper
public interface BooksMapper {

    @Select("select * from Books")
    List<Books> findAll();

    @Insert("insert into Books(name, price) values(#{name}, #{price})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
        before = false, resultType = Integer.class)
    void insert(Books books);

    @Update("update Books set price=#{price}, name=#{name} where id=#{id}")
    void update(Books books);

    @Delete("delete from Books where id=#{id}")
    void delete(int id);


}
