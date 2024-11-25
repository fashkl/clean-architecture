package com.example.hexagonalarchitecture.infrastructure.adapters.outbound.db;

import com.example.hexagonalarchitecture.domain.model.AuthorId;
import com.example.hexagonalarchitecture.domain.model.Book;
import com.example.hexagonalarchitecture.domain.model.BookId;
import com.example.hexagonalarchitecture.domain.ports.BookRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class PostgresqlBookRepository implements BookRepository {

    private final BookRepositoryJpa bookRepositoryJpa;

    public PostgresqlBookRepository(BookRepositoryJpa bookRepositoryJpa) {
        this.bookRepositoryJpa = bookRepositoryJpa;
    }

    @Override
    public void save(Book book) {
        BookJpaEntity bookJpaEntity = new BookJpaEntity();
        bookJpaEntity.setId(Optional.ofNullable(book.id().value())
                .orElse(BookId.randomBookId().value()));
        bookJpaEntity.setTitle(book.title());
        bookJpaEntity.setAuthor(book.author().value());

        bookRepositoryJpa.save(bookJpaEntity);
    }

    @Override
    public List<Book> findAll() {
        return bookRepositoryJpa.findAll().stream()
                .map(bookJpaEntity -> Book.builder()
                        .id(new BookId(bookJpaEntity.getId()))
                        .title(bookJpaEntity.getTitle())
                        .author(new AuthorId(bookJpaEntity.getAuthor()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Book findById(BookId id) {
        return bookRepositoryJpa.findById(id.value())
                .map(bookJpaEntity -> Book.builder()
                        .id(new BookId(bookJpaEntity.getId()))
                        .title(bookJpaEntity.getTitle())
                        .author(new AuthorId(bookJpaEntity.getAuthor()))
                        .build())
                .orElse(null);
    }

    @Override
    public void deleteById(BookId id) {
        bookRepositoryJpa.deleteById(id.value());
    }
}
