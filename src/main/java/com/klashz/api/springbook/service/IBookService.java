package com.klashz.api.springbook.service;

import com.klashz.api.springbook.dto.BookDto;
import com.klashz.api.springbook.models.BookEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IBookService {

    Optional<BookEntity> findById(UUID id);
    List<BookEntity> findAll();
    void create(BookEntity bookEntity);
    void delete(UUID id);
}
