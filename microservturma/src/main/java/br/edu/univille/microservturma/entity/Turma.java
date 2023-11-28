package br.edu.univille.microservturma.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container (containerName = "turma")
public class Turma {
    @Id
    @GeneratedValue
    private String idTurma;
    @PartitionKey
    public String nomeTurma;
    public int semestre;
    public String representante;
    public List<Aluno> listaAlunos = new ArrayList<Aluno>();


    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }
    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
    public String getIdTurma() {
        return idTurma;
    }
    public void setIdTurma(String idTurma) {
        this.idTurma = idTurma;
    }
    public String getNomeTurma() {
        return nomeTurma;
    }
    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    public String getRepresentante() {
        return representante;
    }
    public void setRepresentante(String representante) {
        this.representante = representante;
    }
    
}
