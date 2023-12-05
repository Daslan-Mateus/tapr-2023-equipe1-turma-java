package br.edu.univille.microservturma.service;

import java.util.List;
import br.edu.univille.microservturma.entity.Professor;


public interface ProfessorService {
    public List<Professor> getAll();
    public Professor getById(String id);
    public Professor saveNew(Professor professor);
    public Professor update(String id, Professor professor);
    public Professor update( Professor professor);
    public Professor delete(String id);
}
