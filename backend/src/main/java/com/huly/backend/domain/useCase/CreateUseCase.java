package com.huly.backend.domain.useCase;

import com.huly.backend.domain.model.Example;
import com.huly.backend.domain.repository.ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso: contiene la lógica de negocio.
 * Solo depende de interfaces del dominio, nunca de infra.
 */
@Service
@RequiredArgsConstructor
public class CreateUseCase {

    private final ExampleRepository exampleRepository;


    public Example execute(String name, String description) {
        //igual deberia ser un mapper en una fun aparte
        Example example = new Example( null,name, description);
        return exampleRepository.save(example);
    }
}
