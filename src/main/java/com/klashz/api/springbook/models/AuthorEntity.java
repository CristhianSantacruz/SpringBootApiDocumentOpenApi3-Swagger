package com.klashz.api.springbook.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "table-author")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthorEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String age;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    private List<BookEntity> books;

}
