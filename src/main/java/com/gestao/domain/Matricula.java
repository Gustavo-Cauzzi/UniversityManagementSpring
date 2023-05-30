package com.gestao.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "matriculas")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_matricula")
    private Integer codMatricula;

    @ManyToOne
    @JoinColumn(name = "cod_universidade", nullable = false)
    private Universidade universidade;

    @ManyToOne
    @JoinColumn(name = "cod_curso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "cod_aluno", nullable = false)
    private Aluno aluno;

    public Matricula() {
    }

    public Integer getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(Integer codMatricula) {
        this.codMatricula = codMatricula;
    }

    public Universidade getUniversidade() {
        return universidade;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
