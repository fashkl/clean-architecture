package com.example.hexagonalarchitecture.infrastructure.adapters.inbound.http;

import com.example.hexagonalarchitecture.application.useCases.AddBookUseCase;
import com.example.hexagonalarchitecture.application.useCases.GetAllBooksUseCase;
import com.example.hexagonalarchitecture.application.useCases.GetBooksUseCase;
import com.example.hexagonalarchitecture.application.useCases.RemoveBookUseCase;
import com.example.hexagonalarchitecture.domain.model.Book;
import com.example.hexagonalarchitecture.infrastructure.adapters.inbound.http.dto.BookCreateDto;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/books")
public class BookController {

    private final AddBookUseCase addBookUseCase;
    private final GetAllBooksUseCase getAllBooksUseCase;
    private final GetBooksUseCase getBooksUseCase;
    private final RemoveBookUseCase removeBookUseCase;

    public BookController(
            AddBookUseCase addBookUseCase,
            GetAllBooksUseCase getAllBooksUseCase,
            GetBooksUseCase getBooksUseCase,
            RemoveBookUseCase removeBookUseCase) {
        this.addBookUseCase = addBookUseCase;
        this.getAllBooksUseCase = getAllBooksUseCase;
        this.getBooksUseCase = getBooksUseCase;
        this.removeBookUseCase = removeBookUseCase;
    }

    @PostMapping
    public void addBook(@RequestBody BookCreateDto book) {
        addBookUseCase.run(book.title(), book.author());
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return getAllBooksUseCase.run();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable UUID id) {
        return getBooksUseCase.run(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable UUID id) {
        removeBookUseCase.run(id);
    }
}
