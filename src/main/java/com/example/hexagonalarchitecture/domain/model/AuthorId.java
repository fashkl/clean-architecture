package com.example.hexagonalarchitecture.domain.model;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

public record BookId(String value) implements Microtype<String> {

    public BookId {
        requireNonNull(value, "id");
        checkArgument(!value.isBlank(), "id must not be blank");
    }

    public static BookId bookId(String id) {
        return new BookId(id);
    }

    @Override
    public String toString() {
        return value;
    }
}
