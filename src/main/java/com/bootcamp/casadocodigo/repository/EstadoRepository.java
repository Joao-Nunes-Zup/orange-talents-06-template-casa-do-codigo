package com.bootcamp.casadocodigo.repository;

import com.bootcamp.casadocodigo.model.Estado;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EstadoRepository extends CrudRepository<Estado, Long> {

    Optional<Estado> findByNomeAndPaisId(String nome, Long paisId);
}
