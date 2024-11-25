package com.example.hexagonalarchitecture.domain.model;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record Book(@NonNull BookId id, @NonNull String title, @NonNull AuthorId author) {}
