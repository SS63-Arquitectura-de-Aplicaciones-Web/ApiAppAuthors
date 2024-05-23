package com.upc.curso.repositorio;

import com.upc.curso.entidades.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookRepositorio extends JpaRepository<Book, Long> {
   @Query("SELECT COUNT(b) FROM books b WHERE b.numberPages>20 and b.author.id = ?1")
   int quantityBooks(Long id);
   List<Book> findBookByAuthor_Id(Long id);//evita manytoone desde author
}
