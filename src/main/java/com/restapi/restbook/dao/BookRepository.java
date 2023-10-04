package com.restapi.restbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.restapi.restbook.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
