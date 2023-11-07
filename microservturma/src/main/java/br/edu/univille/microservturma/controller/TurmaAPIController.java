package br.edu.univille.microservturma.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.http.HttpStatus;

@Controller 
@RequestMapping("api/v1/turma")
public class TurmaAPIController {
    public ResponseEntity<List<Turma>> listaTurma (){
        var  listaTurma = new ArrayList<Turma>();

        return
            new ResponseEntity<List<Turma>>(listaTurma, HttpStatus.OK);
    }
    
}
