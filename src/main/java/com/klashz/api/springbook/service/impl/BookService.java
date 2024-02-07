package com.klashz.api.springbook.service.impl;

import com.klashz.api.springbook.dto.BookDto;
import com.klashz.api.springbook.models.BookEntity;
import com.klashz.api.springbook.repository.BookRepository;
import com.klashz.api.springbook.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService  implements IBookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Optional<BookEntity> findById(UUID id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void create(BookEntity bookEntity) {
       bookRepository.save(bookEntity);
    }

    @Override
    public void delete(UUID id) {
        bookRepository.deleteById(id);
    }
}
