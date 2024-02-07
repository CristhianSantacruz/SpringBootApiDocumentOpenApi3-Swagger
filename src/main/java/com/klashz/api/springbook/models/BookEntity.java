package com.klashz.api.springbook.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.AnyKeyJavaClass;

import java.util.UUID;

@Entity
@Table(name = "table-book")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String year;
    @ManyToOne(targetEntity = AuthorEntity.class)
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private AuthorEntity author;

}
