package ifsuldeminas.pas.bcc.biblioteca.controller;

import ifsuldeminas.pas.bcc.biblioteca.model.entities.Livro;
import ifsuldeminas.pas.bcc.biblioteca.model.entities.repositories.LivroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")//Marcador da URI
public class LivroController {
    private LivroRepository livroRepository;

    //Busca uma Lista de Livros.
    @GetMapping
    public List<Livro> read(){
        return livroRepository.findAll();
    }//Fim do Read Lista.

    //Busca um Livro em específico.
    @GetMapping("/{id}")
    public Livro read(@PathVariable Long id){
        return livroRepository.getById(id);
    }//Fim do Read.

    //Cria um novo Livro.
    @PostMapping
    public Livro create(@RequestBody Livro livro){
        return livroRepository.save(livro);
    }//Fim do Create

    //Altera um Livro ja cadastrado.
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
    }//Fim do Update.

    //Deleta um Livro específico ja cadastrado.
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        livroRepository.deleteById(id);
    }//Fim do Delete
}//FIm da classe LivroController.
