package ifsuldeminas.pas.bcc.biblioteca.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Usuário #"+ id +"não encontrado!");
    }
}