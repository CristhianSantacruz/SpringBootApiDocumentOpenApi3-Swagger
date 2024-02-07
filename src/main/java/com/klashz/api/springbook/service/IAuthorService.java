package com.klashz.api.springbook.service;

import com.klashz.api.springbook.models.AuthorEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IAuthorService {
    Optional<AuthorEntity> findById(UUID id);
    List<AuthorEntity> findAll();
    void create(AuthorEntity AuthorEntity);
    void delete(UUID id);
}
