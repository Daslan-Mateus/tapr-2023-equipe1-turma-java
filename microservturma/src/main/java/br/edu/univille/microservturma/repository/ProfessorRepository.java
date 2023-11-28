package br.edu.univille.microservturma.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.univille.microservturma.entity.Professor;



@Repository
public interface ProfessorRepository extends CrudRepository<Professor, String> {

}