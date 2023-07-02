package com.gestao.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "disciplina_curso")
public class DisciplinaCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_disciplina_curso")
    private Integer codDisciplinaCurso;

    @Column(name = "cod_curso")
    private Integer codCurso;

    @Column(name = "cod_disciplina")
    private Integer codDisciplina;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cod_curso", insertable = false, updatable = false)
    private Curso curso;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cod_disciplina", insertable = false, updatable = false)
    private Disciplina disciplina;

    public DisciplinaCurso() {
    }

    public DisciplinaCurso(Integer codDisciplinaCurso, Curso curso, Disciplina disciplina) {
        this.codDisciplinaCurso = codDisciplinaCurso;
        this.curso = curso;
        this.disciplina = disciplina;
    }

    public Integer getCodDisciplinaCurso() {
        return codDisciplinaCurso;
    }

    public void setCodDisciplinaCurso(Integer codDisciplinaCurso) {
        this.codDisciplinaCurso = codDisciplinaCurso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public Integer getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }
}
