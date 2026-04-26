package com.huly.backend.domain.repository;



import com.huly.backend.domain.model.Example;

import java.util.List;
import java.util.Optional;

/**
 * Puerto (interfaz) del repositorio.
 * El dominio define el contrato; la infra lo implementa.
 */
public interface ExampleRepository {

    Example save(Example example);

}