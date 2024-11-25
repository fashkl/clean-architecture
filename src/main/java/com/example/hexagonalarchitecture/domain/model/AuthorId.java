package com.example.hexagonalarchitecture.domain.model;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

public record AuthorId(String value) implements Microtype<String> {

    public AuthorId {
        requireNonNull(value, "id");
        checkArgument(!value.isBlank(), "id must not be blank");
    }

    public static AuthorId authorId(String id) {
        return new AuthorId(id);
    }

    @Override
    public String toString() {
        return value;
    }
}
