package com.example.hexagonalarchitecture.application.useCases;

import com.example.hexagonalarchitecture.domain.model.Book;
import com.example.hexagonalarchitecture.domain.model.BookId;
import com.example.hexagonalarchitecture.domain.ports.BookRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class GetBooksUseCase {
    private final BookRepository bookRepository;

    public GetBooksUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> run(UUID id) {
        return Optional.ofNullable(bookRepository.findById(BookId.bookId(id)));
    }
}
