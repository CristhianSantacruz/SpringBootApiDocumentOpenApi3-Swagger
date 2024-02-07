package com.klashz.api.springbook.dto;

import com.klashz.api.springbook.models.BookEntity;
import lombok.*;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthorDto {

    private UUID id;
    private String name;
    private String age;
    private String email;
    private String phone;

    private List<BookEntity> books;
}
