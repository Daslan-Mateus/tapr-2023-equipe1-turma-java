package br.edu.univille.entity;

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
