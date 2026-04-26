package com.huly.backend.infrastructure.repository.jpaRepository.interfaces;

import com.huly.backend.infrastructure.repository.entity.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExampleJpaRepository extends JpaRepository<ExampleEntity, Long> {

}
