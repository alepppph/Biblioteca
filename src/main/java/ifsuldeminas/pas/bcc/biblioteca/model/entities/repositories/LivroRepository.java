package ifsuldeminas.pas.bcc.biblioteca.model.entities.repositories;

import ifsuldeminas.pas.bcc.biblioteca.model.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <Livro, Long> {

}
