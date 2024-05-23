package com.upc.curso.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
public class Book {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @Column(name = "nameBook", length = 45, nullable = false)
   private String nameBook;
   @Column(name = "publicationDateBook", nullable = false)
   private LocalDate publicationDateBook;
   @Column(name = "numberPages", nullable = false)
   private int numberPages;
   @ManyToOne(targetEntity = Author.class)
   @JoinColumn(name = "author_id", referencedColumnName = "id")
   @JsonBackReference("book_items")
   private Author author;
}
