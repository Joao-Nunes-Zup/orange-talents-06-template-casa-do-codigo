package com.bootcamp.casadocodigo.repository;

import com.bootcamp.casadocodigo.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
