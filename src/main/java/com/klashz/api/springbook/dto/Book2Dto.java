package com.klashz.api.springbook.dto;

import com.klashz.api.springbook.models.AuthorEntity;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book2Dto {

    private UUID id;
    private String title;
    private String year;
    private String nameAuthor;
}
