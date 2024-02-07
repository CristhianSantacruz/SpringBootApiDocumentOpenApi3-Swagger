package com.klashz.api.springbook.repository;

import com.klashz.api.springbook.models.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository  extends JpaRepository<BookEntity, UUID> {
}
