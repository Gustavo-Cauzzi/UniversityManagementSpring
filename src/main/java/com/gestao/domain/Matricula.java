package com.gestao.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "matriculas")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_matricula")
    private Integer codMatricula;

    @JsonIgnoreProperties({"disciplinaCurso", "matriculas"})
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cod_curso", insertable = false, updatable = false)
    private Curso curso;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cod_aluno", insertable = false, updatable = false)
    private Aluno aluno;

    @Column(name = "cod_curso", nullable = false)
    private Integer codCurso;

    @Column(name = "cod_aluno", nullable = false)
    private Integer codAluno;

    public Matricula() {
    }

    public Integer getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(Integer codMatricula) {
        this.codMatricula = codMatricula;
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


    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public Integer getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(Integer codAluno) {
        this.codAluno = codAluno;
    }
}
