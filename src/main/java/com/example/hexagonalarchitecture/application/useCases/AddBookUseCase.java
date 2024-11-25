package com.example.hexagonalarchitecture.application.useCases;

import com.example.hexagonalarchitecture.domain.model.AuthorId;
import com.example.hexagonalarchitecture.domain.model.Book;
import com.example.hexagonalarchitecture.domain.model.BookId;
import com.example.hexagonalarchitecture.domain.ports.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class AddBookUseCase {
    private final BookRepository bookRepository;

    public AddBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void run(String title, String author) {
        Book book = Book.builder()
                .id(BookId.randomBookId())
                .title(title)
                .author(AuthorId.authorId(author))
                .build();

        bookRepository.save(book);
    }
}
