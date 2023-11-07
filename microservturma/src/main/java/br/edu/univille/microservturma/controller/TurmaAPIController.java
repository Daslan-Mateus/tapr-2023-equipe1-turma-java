package br.edu.univille.microservturma.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.univille.microservturma.entity.Turma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller 
@RequestMapping("api/v1/turma")
public class TurmaAPIController {
    @GetMapping
    public ResponseEntity<List<Turma>> listaTurma (){
        var  listaTurma = new ArrayList<Turma>();

        return
            new ResponseEntity<List<Turma>>(listaTurma, HttpStatus.OK);
    }
    
}
