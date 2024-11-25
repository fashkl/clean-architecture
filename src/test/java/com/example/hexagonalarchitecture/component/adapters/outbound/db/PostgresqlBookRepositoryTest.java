package com.example.hexagonalarchitecture.component.adapters.outbound.db;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.hexagonalarchitecture.domain.model.Book;
import com.example.hexagonalarchitecture.domain.ports.BookRepository;
import com.example.hexagonalarchitecture.infrastructure.adapters.outbound.db.PostgresqlBookRepository;
import com.example.hexagonalarchitecture.testFixtures.ModelTestData;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import(PostgresqlBookRepository.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostgresqlBookRepositoryTest implements ModelTestData {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveAndFindById() {
        Book book = Book.builder()
                .id(aBookId())
                .title(aTitle())
                .author(anAuthorId())
                .build();
        bookRepository.save(book);

        var foundBook = Optional.ofNullable(bookRepository.findById(book.id()));
        assertThat(foundBook).isPresent();
        assertThat(foundBook.get().title()).isEqualTo(book.title());
    }

    @Test
    public void testFindAll() {
        Book book = Book.builder()
                .id(aBookId())
                .title(aTitle())
                .author(anAuthorId())
                .build();
        bookRepository.save(book);

        var books = bookRepository.findAll();
        assertThat(books).isNotEmpty();
        assertThat(books.get(0).title()).isEqualTo(book.title());
    }

    @Test
    public void testDeleteById() {
        Book book = Book.builder()
                .id(aBookId())
                .title(aTitle())
                .author(anAuthorId())
                .build();
        bookRepository.save(book);

        bookRepository.deleteById(book.id());
        var foundBook = Optional.ofNullable(bookRepository.findById(book.id()));
        assertThat(foundBook).isEmpty();
    }
}
