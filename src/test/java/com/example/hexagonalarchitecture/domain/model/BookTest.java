package com.example.hexagonalarchitecture.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.hexagonalarchitecture.testFixtures.ModelTestData;
import org.junit.jupiter.api.Test;

public class BookTest implements ModelTestData {

    @Test
    void shouldCreateBook() {
        var id = aBookId();
        var title = aTitle();
        var author = anAuthorId();

        var book = Book.builder().id(id).title(title).author(author).build();

        assertThat(book.id()).isEqualTo(id);
        assertThat(book.title()).isEqualTo(title);
        assertThat(book.author()).isEqualTo(author);
    }
}
