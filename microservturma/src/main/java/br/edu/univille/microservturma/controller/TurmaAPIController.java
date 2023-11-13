package br.edu.univille.microservturma.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.univille.microservturma.entity.Turma;
import br.edu.univille.microservturma.service.TurmaService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller 
@RequestMapping("api/v1/turma")
public class TurmaAPIController {
    @Autowired
    private TurmaService service;
    @GetMapping
    public ResponseEntity<List<Turma>> listaTurma (){
        var  listaTurma = new ArrayList<Turma>();

        return
            new ResponseEntity<List<Turma>>(listaTurma, HttpStatus.OK);
    }
    
}
