package com.jay.dao;

import com.jay.pojo.Books;

import java.util.List;

public interface BookMapper {

    int addBook(Books books);

    int deleteBook(int id);

    int updateBook(Books books);

    Books queryBookById(int id);

    List<Books> queryAllBook();
}

