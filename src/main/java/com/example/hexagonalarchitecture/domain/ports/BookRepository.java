package com.example.hexagonalarchitecture.domain.ports;

import com.example.hexagonalarchitecture.domain.model.Book;
import com.example.hexagonalarchitecture.domain.model.BookId;
import java.util.List;

public interface BookRepository {
    void save(Book book);

    List<Book> findAll();

    Book findById(BookId id);

    void deleteById(BookId id);
}
