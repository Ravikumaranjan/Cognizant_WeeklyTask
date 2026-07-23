
package com.lpu.library.repository;
import com.lpu.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book,Long>{}
