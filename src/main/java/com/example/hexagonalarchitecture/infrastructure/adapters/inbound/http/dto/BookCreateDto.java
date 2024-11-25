package com.example.hexagonalarchitecture.infrastructure.adapters.inbound.http.dto;

import lombok.NonNull;

public record BookCreateDto(@NonNull String title, @NonNull String author) {}
