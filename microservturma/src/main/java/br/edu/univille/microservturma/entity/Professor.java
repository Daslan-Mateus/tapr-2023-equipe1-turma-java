package br.edu.univille.microservturma.entity;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "professor",autoCreateContainer = true)
public class Professor {

    @Id
    @PartitionKey
    @GeneratedValue
    private String id;
    private int matricula;
    private String nome;
    private String disciplina;

    public String getId() {
    return id;
    }
    public void setId(String id) {
    this.id = id;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public void setIdProfessor(Object object) {
    }
    public Object getIdprofessor() {
        return null;
    }

}
