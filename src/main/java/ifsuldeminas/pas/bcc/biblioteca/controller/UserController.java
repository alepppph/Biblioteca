package ifsuldeminas.pas.bcc.biblioteca.controller;


import ifsuldeminas.pas.bcc.biblioteca.model.entities.Usuario;
import ifsuldeminas.pas.bcc.biblioteca.model.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    //Delega o Spring para instanciar planoRepository
    public UserController(UserService userService){
        this.userService = userService;
    }

    //Busca todos os usuários cadastrados.
    @GetMapping
    public List<Usuario> read(){
        List<Usuario> usuarios = userService.get();
        return usuarios;
    }//Fim do Read Lista.

    //Busca um usuário específico cadastrado.
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> read(@PathVariable Long id){
         Usuario usuario = userService.get(id);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }//Fim do Read.

    //Cadastra um usuário.
    @PostMapping
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario){
        usuario = userService.create(usuario);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
    }//Fim do Create.

    //Altera os dados de um usuário cadastrado.
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@Valid @RequestBody Usuario usuario, @PathVariable Long id){
        Usuario usuarioAtualizado = userService.update(id, usuario);
        return new ResponseEntity<Usuario>(usuarioAtualizado, HttpStatus.OK);
    }//Fim do Update.

    //Exclui um usuário já cadastrado.
    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
    }//Fim do Delete.
}//Fim da Classe UserController.