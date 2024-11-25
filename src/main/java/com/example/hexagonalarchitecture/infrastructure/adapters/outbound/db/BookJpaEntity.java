package com.example.hexagonalarchitecture.infrastructure.adapters.outbound.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Data;

@Entity
@Data
public class BookJpaEntity {
    @Id
    private UUID id;

    private String title;
    private String author;
}
