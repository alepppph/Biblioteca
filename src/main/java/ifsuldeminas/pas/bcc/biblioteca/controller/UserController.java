package ifsuldeminas.pas.bcc.biblioteca.controller;

import ifsuldeminas.pas.bcc.biblioteca.model.entities.Usuario;
import ifsuldeminas.pas.bcc.biblioteca.model.entities.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    //Busca todos os usuários cadastrados.
    @GetMapping
    public List<Usuario> read(){
        return userRepository.findAll();
    }//Fim do Read Lista.

    //Busca um usuário específico cadastrado.
    @GetMapping("/{id}")
    public Usuario read(@PathVariable Long id){
        return userRepository.getById(id);
    }//Fim do Read.

    //Cadastra um usuário.
    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return userRepository.save(usuario);
    }//Fim do Create.

    //Altera os dados de um usuário cadastrado.
    @PutMapping("/{id}")
    public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id){
        Usuario user_aux = userRepository.getById(id);

        //Atributos de Usuário
        user_aux.setTipo(user_aux.getTipo());
        user_aux.setDataCadastro(user_aux.getDataCadastro());
        user_aux.setMatricula(user_aux.getMatricula());
        user_aux.setReservas(user_aux.getReservas());

        return userRepository.save(user_aux);
    }//Fim do Update.

    //Exclui um usuário já cadastrado.
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        userRepository.deleteById(id);
    }//Fim do Delete.
}//Fim da Classe UserController.
