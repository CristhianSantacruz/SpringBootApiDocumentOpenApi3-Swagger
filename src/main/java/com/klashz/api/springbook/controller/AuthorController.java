package com.klashz.api.springbook.controller;

import com.klashz.api.springbook.dto.AuthorDto;
import com.klashz.api.springbook.models.AuthorEntity;
import com.klashz.api.springbook.service.impl.AuthorService;
import com.sun.security.jgss.AuthorizationDataEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/author")
public class AuthorController {
    
    @Autowired
    AuthorService authorService;

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        Optional<AuthorEntity> author0 = authorService.findById(id);
        if (author0.isPresent()) {
            AuthorEntity authorEntity = author0.get();
            return ResponseEntity.ok(AuthorDto.builder()
                            .age(authorEntity.getAge())
                            .name(authorEntity.getName())
                            .email(authorEntity.getEmail())
                            .phone(authorEntity.getPhone())
                            .id(authorEntity.getId())
                    .books(authorEntity.getBooks())
                    .build());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }
    }
    @GetMapping("/all")
    public ResponseEntity<?> findAll(){

        List<AuthorDto> authorEntities = authorService.findAll()
                .stream().map(authorEntity -> AuthorDto.builder()
                        .age(authorEntity.getAge())
                        .name(authorEntity.getName())
                        .email(authorEntity.getEmail())
                        .phone(authorEntity.getPhone())
                        .id(authorEntity.getId())
                        .books(authorEntity.getBooks())
                        .build()).toList();
        return ResponseEntity.ok(authorEntities);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(AuthorDto authorDto){
        AuthorEntity authorEntity = AuthorEntity.builder()
                .age(authorDto.getAge())
                .name(authorDto.getName())
                .books(authorDto.getBooks())
                .phone(authorDto.getPhone())
                .email(authorDto.getEmail())
                .books(authorDto.getBooks())
                .build();
        return ResponseEntity.ok(authorEntity);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id){
        authorService.delete(id);
        return ResponseEntity.ok("Author Deleted!");
    }
}
