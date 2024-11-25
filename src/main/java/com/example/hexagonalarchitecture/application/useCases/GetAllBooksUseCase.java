package com.example.hexagonalarchitecture.application.useCases;

import com.example.hexagonalarchitecture.domain.model.Book;
import com.example.hexagonalarchitecture.domain.ports.BookRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GetAllBooksUseCase {
    private final BookRepository bookRepository;

    public GetAllBooksUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> run() {
        return bookRepository.findAll();
    }
}
