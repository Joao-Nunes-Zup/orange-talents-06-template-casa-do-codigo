package com.bootcamp.casadocodigo.repository;

import com.bootcamp.casadocodigo.model.Estado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends CrudRepository<Estado, Long> {

    Optional<Estado> findByNomeAndPaisId(String nome, Long paisId);

    List<Estado> findByPaisId(Long paisId);

    @Query(
        value = "select e.pais_id from estados e where e.id = :estadoId",
        nativeQuery = true
    )
    Long encontraOIdDoPaisPeloIdDoEstado(Long estadoId);
}
