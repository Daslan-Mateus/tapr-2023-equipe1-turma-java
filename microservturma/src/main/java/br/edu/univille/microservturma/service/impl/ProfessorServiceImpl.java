package br.edu.univille.microservturma.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;

import br.edu.univille.microservturma.entity.Professor;
import br.edu.univille.microservturma.repository.ProfessorRepository;
import br.edu.univille.microservturma.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    private ProfessorRepository repository;

    private DaprClient client = new DaprClientBuilder().build();
    @Value("${app.component.topic.turma}")
    private String TOPIC_NAME;
    @Value("${app.component.service}")
	private String PUBSUB_NAME;

    @Override
    public List<Professor> getAll() {
        var iterador = repository.findAll();
        List<Professor>listProfessores = new ArrayList <>();
        
        iterador.forEach(listProfessores :: add);

        return listProfessores;
}

    @Override
    public Professor getById(String id) {
        var professor = repository.findById(id);
        if(professor.isPresent())
            return professor.get();
        return null;
    }

    @Override
    public Professor saveNew(Professor professor) {
        professor.setIdProfessor(null);
        publicarAtualizacao(professor);
        return repository.save(professor);
    }

    @Override
    public Professor update(String id, Professor professor) {
        var buscaProfessorAntigo = repository.findById(id);
        if (buscaProfessorAntigo.isPresent()){
            var professorAntigo = buscaProfessorAntigo.get();

            //Atualizar cada atributo do objeto antigo 
            professorAntigo.setIdProfessor(professor.getIdprofessor());
            professorAntigo = repository.save(professorAntigo);
            
            return professorAntigo;
        }
        return null;
    }

    @Override
    public Professor delete(String id) {
        var buscaProfessor = repository.findById(id);
        if (buscaProfessor.isPresent()){
            var professor = buscaProfessor.get();

            repository.delete(professor);

            return professor;
        }
        return null;
    }

     //método privado para publicar a atualização
    private void publicarAtualizacao(Professor professor){
        client.publishEvent(
					PUBSUB_NAME,
					TOPIC_NAME,
					professor).block();
    }
}
