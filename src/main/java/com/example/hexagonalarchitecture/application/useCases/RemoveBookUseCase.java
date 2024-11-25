package com.example.hexagonalarchitecture.application.useCases;

import com.example.hexagonalarchitecture.domain.model.BookId;
import com.example.hexagonalarchitecture.domain.ports.BookRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class RemoveBookUseCase {
    private final BookRepository bookRepository;

    public RemoveBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void run(UUID id) {
        bookRepository.deleteById(BookId.bookId(id));
    }
}
