package com.klashz.api.springbook.service.impl;

import com.klashz.api.springbook.models.AuthorEntity;
import com.klashz.api.springbook.repository.AuthorRepository;
import com.klashz.api.springbook.service.IAuthorService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService  implements IAuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Optional<AuthorEntity> findById(UUID id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<AuthorEntity> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void create(AuthorEntity authorEntity) {
        authorRepository.save(authorEntity);
    }

    @Override
    public void delete(UUID id) {
        authorRepository.deleteById(id);
    }
}
