package br.edu.univille.microservturma.service;

import java.util.List;

import br.edu.univille.microservturma.entity.Turma;

public interface TurmaService {
    public List<Turma> getAll();
    public Turma getById(String id);
    public Turma saveNew(Turma turma);
    public Turma update(String id, Turma turma);
    public Turma delete(String id);
}
