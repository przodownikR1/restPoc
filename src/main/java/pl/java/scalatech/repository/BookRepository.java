package pl.java.scalatech.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByNameAndPrice(String name, Integer price, Pageable pageable);

    Page<Book> findByName(String name, Pageable pageable);
}