package com.huly.backend.infrastructure.repository.jpaRepository.implementation;

import com.huly.backend.domain.model.Example;
import com.huly.backend.domain.repository.ExampleRepository;
import com.huly.backend.infrastructure.repository.entity.ExampleEntity;
import com.huly.backend.infrastructure.repository.jpaRepository.interfaces.IExampleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Implementación del puerto ExampleRepository.
 * Traduce entre Entity (infra) y Model (dominio).
 */
@RequiredArgsConstructor
@Component
public class ExampleRepositoryImpl implements ExampleRepository {

    private final IExampleJpaRepository jpa;


    @Override
    public Example save(Example example) {
        ExampleEntity entity = toEntity(example);   // ← convertís primero
        ExampleEntity saved  = jpa.save(entity);    // ← guardás la entity
        return toDomain(saved);                     // ← devolvés el domain model
    }

    private ExampleEntity toEntity(Example d) {
        return ExampleEntity.builder()
                .name(d.getName())
                .description(d.getDescription())
                .active(true)
                .build();
    }

    private Example toDomain(ExampleEntity e) {
        return Example.builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .build();
    }

}
