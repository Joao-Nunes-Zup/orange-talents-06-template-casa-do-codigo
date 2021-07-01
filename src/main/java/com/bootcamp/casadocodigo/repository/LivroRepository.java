package com.bootcamp.casadocodigo.repository;

import com.bootcamp.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
