package br.edu.univille.microservturma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        while (iterador.iterator().hasNext()) {
            var umItem = iterador.iterator().next();
            listTurmas.add(umItem);
            
        }


        return listTurmas;
}
