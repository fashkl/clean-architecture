package com.example.hexagonalarchitecture.infrastructure.adapters.outbound.db;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositoryJpa extends JpaRepository<BookJpaEntity, UUID> {}
