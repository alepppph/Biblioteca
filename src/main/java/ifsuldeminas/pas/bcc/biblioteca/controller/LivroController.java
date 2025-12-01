package ifsuldeminas.pas.bcc.biblioteca.controller;

import ifsuldeminas.pas.bcc.biblioteca.model.entities.Livro;
import ifsuldeminas.pas.bcc.biblioteca.model.entities.repositories.LivroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private LivroRepository livroRepository;

    @GetMapping
    public List<Livro> list(){
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Livro show(@PathVariable Long id){
        return livroRepository.getById(id);
    }

    @PostMapping
    public Livro save(@RequestBody Livro livro){
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public Livro update(@PathVariable Long id, @RequestBody Livro livro){
        Livro livro_aux = livroRepository.getById(id);

        //Atributos do Livro
        livro_aux.setTitulo(livro.getTitulo());
        livro_aux.setEditora(livro.getEditora());
        livro_aux.setIdioma(livro.getIdioma());
        livro_aux.setIsbn(livro.getIsbn());
        livro_aux.setQtdPaginas(livro.getQtdPaginas());
        livro_aux.setAnoPublicacao(livro.getAnoPublicacao());

        return livroRepository.save(livro_aux);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        livroRepository.deleteById(id);
    }
}
