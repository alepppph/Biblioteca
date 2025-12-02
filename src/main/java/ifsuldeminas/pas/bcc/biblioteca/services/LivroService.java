package com.biblioteca.demo.service;

import com.biblioteca.demo.model.entities.Livro;
import com.biblioteca.demo.model.entities.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado!"));
    }

    public Livro salvar(Livro livro) {
        return repository.save(livro);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Tentativa de excluir livro inexistente.");
        }
        repository.deleteById(id);
    }
}
