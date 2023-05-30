package com.gestao.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "disciplina_curso")
public class DisciplinaCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_disciplina_curso")
    private Integer codDisciplinaCurso;

    @ManyToOne
    @JoinColumn(name = "cod_curso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "cod_disciplina", nullable = false)
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
}
