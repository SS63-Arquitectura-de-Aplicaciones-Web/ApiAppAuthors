package com.upc.curso.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity //Agnóstica
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nameAuthor", length = 60, nullable = false)
    private String nameAuthor;
    private LocalDate birthDateAuthor;
    @Column(name = "emailAuthor",length = 35,nullable = false)
    private String emailAuthor;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonManagedReference("book_items")
    private List<Book> books;

}
