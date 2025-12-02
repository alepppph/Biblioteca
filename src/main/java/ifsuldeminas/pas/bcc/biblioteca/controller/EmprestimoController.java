package ifsuldeminas.pas.bcc.biblioteca.controller;

import ifsuldeminas.pas.bcc.biblioteca.model.entities.Emprestimo;
import ifsuldeminas.pas.bcc.biblioteca.model.entities.repositories.EmprestimoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")//Marcador da URI
public class EmprestimoController {
    private EmprestimoRepository emprestimoRepository;

    //Busca a lista de emprestimos cadastrados.
    @GetMapping
    public List<Emprestimo> read(){
        return emprestimoRepository.findAll();
    }//Fim do Read Lista.

    //Busca um emprestimo específico cadastrado.
    @GetMapping("/{id}")
    public Emprestimo read(@PathVariable Long id){
        return emprestimoRepository.getById(id);
    }//Fim do Read.

    //Faz o cadastro de emprestimo.
    @PostMapping
    public Emprestimo create(@RequestBody Emprestimo emprestimo){
        return emprestimoRepository.save(emprestimo);
    }//Fim do Create.

    //Altera um emprestimo já cadastrado.
    @PutMapping("/{id}")
    public Emprestimo update(@PathVariable Long id, @RequestBody Emprestimo emprestimo){
        Emprestimo emprestimo_aux = emprestimoRepository.getById(id);

        //Atributos de Emprestimo
        emprestimo_aux.setMulta(emprestimo.getMulta());
        emprestimo_aux.setDataRetirada(emprestimo.getDataRetirada());
        emprestimo_aux.setStatus(emprestimo.getStatus());
        emprestimo_aux.setDataDevolucaoReal(emprestimo.getDataDevolucaoReal());
        emprestimo_aux.setUsuario(emprestimo.getUsuario());

        return emprestimoRepository.save(emprestimo_aux);
    }//Fim do Update.

    //Deleta um emprestimo ja cadastrado.
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        emprestimoRepository.deleteById(id);
    }//Fim do Delete.
}//Fim da classe EmprestimoController.
