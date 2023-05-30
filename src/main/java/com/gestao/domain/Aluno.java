package com.gestao.domain;

import com.gestao.domain.Curso;
import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_aluno")
    private Integer codAluno;

    @Column(name = "des_aluno", unique = true, nullable = false)
    private String desAluno;

    @ManyToOne
    @JoinColumn(name = "cod_curso", nullable = false)
    private Curso curso;

    public Aluno() {
    }

    public Aluno(Integer codAluno, String desAluno, Curso curso) {
        this.codAluno = codAluno;
        this.desAluno = desAluno;
        this.curso = curso;
    }

    public Integer getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(Integer codAluno) {
        this.codAluno = codAluno;
    }

    public String getDesAluno() {
        return desAluno;
    }

    public void setDesAluno(String desAluno) {
        this.desAluno = desAluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}