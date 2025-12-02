package ifsuldeminas.pas.bcc.biblioteca.model.services;

import ifsuldeminas.pas.bcc.biblioteca.exceptions.UserNotFoundException;
import ifsuldeminas.pas.bcc.biblioteca.model.entities.Usuario;
import ifsuldeminas.pas.bcc.biblioteca.model.entities.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Usuario create(Usuario usuario){
        return userRepository.save(usuario);
    }

    public Usuario get(Long id){
        Optional<Usuario> opt = userRepository.findById(id);
        if(opt.isPresent()){
            throw new UserNotFoundException(id);
        }
        return opt.get();
    }

    public List<Usuario> get(){
        return userRepository.findAll();
    }

    public Usuario update(Long id, Usuario usuario){
        Usuario usuarioCadastrado = get(id);
        usuarioCadastrado.setTipo(usuarioCadastrado.getTipo());
        usuarioCadastrado.setDataCadastro(usuarioCadastrado.getDataCadastro());
        usuarioCadastrado.setMatricula(usuarioCadastrado.getMatricula());
        usuarioCadastrado.setReservas(usuarioCadastrado.getReservas());
        userRepository.save(usuarioCadastrado);
        return usuarioCadastrado;
    }

    public void delete(Long id){
        if(!userRepository.existsById(id)){
            throw  new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
}