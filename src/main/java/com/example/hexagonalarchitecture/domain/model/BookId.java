package com.example.hexagonalarchitecture.domain.model;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;
import static java.util.UUID.randomUUID;

import java.util.UUID;

public record BookId(UUID value) implements Microtype<UUID> {

    public BookId {
        requireNonNull(value, "id");
        checkArgument(!value.toString().isBlank(), "id must not be blank");
    }

    public static BookId bookId(UUID id) {
        return new BookId(id);
    }

    public static BookId randomBookId() {
        return bookId(randomUUID());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
