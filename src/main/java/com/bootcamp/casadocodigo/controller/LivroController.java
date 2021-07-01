package com.bootcamp.casadocodigo.controller;

import com.bootcamp.casadocodigo.dto.LivroParaListagemResponse;
import com.bootcamp.casadocodigo.dto.NovoLivroRequest;
import com.bootcamp.casadocodigo.dto.NovoLivroResponse;
import com.bootcamp.casadocodigo.model.Autor;
import com.bootcamp.casadocodigo.model.Categoria;
import com.bootcamp.casadocodigo.model.Livro;
import com.bootcamp.casadocodigo.repository.AutorRepository;
import com.bootcamp.casadocodigo.repository.CategoriaRepository;
import com.bootcamp.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    @GetMapping
    public List<LivroParaListagemResponse> listar() {
        List<Livro> livros = livroRepository.findAll();

        return livros.stream()
                .map(Livro::toDtoListagem)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Long id) {
        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(livro.get().toDtoDetalhes());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<NovoLivroResponse> criar(@RequestBody @Valid NovoLivroRequest livroRequest) {
        Optional<Categoria> categoria = categoriaRepository.findById(livroRequest.getCategoriaId());
        Optional<Autor> autor = autorRepository.findById(livroRequest.getAutorId());

        if (categoria.isPresent() && autor.isPresent()) {
            Livro livro = livroRequest.toEntity(categoria.get(), autor.get());
            livroRepository.save(livro);
            return ResponseEntity.ok(livro.toDto());
        }

        return ResponseEntity.badRequest().build();
    }
}
