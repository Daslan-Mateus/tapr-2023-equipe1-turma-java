package br.edu.univille.microservturma.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.microservturma.entity.Turma;
import br.edu.univille.microservturma.repository.TurmaRepository;
import br.edu.univille.microservturma.service.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService {
    @Autowired
    private TurmaRepository repository;

    @Override
    public List<Turma> getAll() {
        var iterador = repository.findAll();
        List<Turma>listTurmas = new ArrayList <>();
        
        iterador.forEach(listTurmas :: add);

        return listTurmas;
}

    @Override
    public Turma getById(String id) {
        var turma = repository.findById(id);
        if(turma.isPresent())
            return turma.get();
        return null;
    }

    @Override
    public Turma saveNew(Turma turma) {
        turma.setIdTurma(null);
        return repository.save(turma);
    }

    @Override
    public Turma update(String id, Turma turma) {
        var buscaTurmaAntigo = repository.findById(id);
        if (buscaTurmaAntigo.isPresent()){
            var turmaAntigo = buscaTurmaAntigo.get();

            //Atualizar cada atributo do objeto antigo 
            turmaAntigo.setIdTurma(turma.getIdTurma());
            
            return repository.save(turmaAntigo);
        }
        return null;
    }

    @Override
    public Turma delete(String id) {
        var buscaTurma = repository.findById(id);
        if (buscaTurma.isPresent()){
            var turma = buscaTurma.get();

            repository.delete(turma);

            return turma;
        }
        return null;
    }
}
