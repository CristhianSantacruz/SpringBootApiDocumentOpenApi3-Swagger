package com.klashz.api.springbook.dto;

import com.klashz.api.springbook.models.AuthorEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookDto {

    private UUID id;
    private String title;
    private String year;
    private AuthorEntity author;
}
