package ifsuldeminas.pas.bcc.biblioteca.model.entities.repositories;

import ifsuldeminas.pas.bcc.biblioteca.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {

}
