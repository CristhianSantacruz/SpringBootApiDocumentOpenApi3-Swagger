package com.klashz.api.springbook.controller;
import com.klashz.api.springbook.dto.Book2Dto;
import com.klashz.api.springbook.dto.BookDto;
import com.klashz.api.springbook.models.BookEntity;
import com.klashz.api.springbook.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        Optional<BookEntity> book0 = bookService.findById(id);
        if (book0.isPresent()) {
            BookEntity bookEntity = book0.get();
            return ResponseEntity.ok(Book2Dto.builder()
                    .title(bookEntity.getTitle())
                    .year(bookEntity.getYear())
                    .title(bookEntity.getTitle())
                    .id(bookEntity.getId())
                            .nameAuthor(bookEntity.getAuthor().getName())
                    .build());
        }
        else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book no found");
        }
    }
    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<Book2Dto> bookDtos = bookService.findAll()
                .stream().map(bookEntity -> Book2Dto.builder()
                        .title(bookEntity.getTitle())
                        .year(bookEntity.getYear())
                        .title(bookEntity.getTitle())
                        .id(bookEntity.getId())
                        .nameAuthor(bookEntity.getAuthor().getName())
                        .build()).toList();
        return ResponseEntity.ok(bookDtos);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(BookDto bookDto){
        BookEntity bookEntity = BookEntity.builder()
                .title(bookDto.getTitle())
                .year(bookDto.getYear())
                .author(bookDto.getAuthor())
                .build();
        bookService.create(bookEntity);
        return ResponseEntity.ok("Se guardo correctamente");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        bookService.delete(id);
        return ResponseEntity.ok("Book Deleted!");
    }
}



