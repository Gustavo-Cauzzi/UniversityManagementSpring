package com.gestao.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos_disciplinas")
public class AlunoDisciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_disciplina_aluno")
    private Integer codDisciplinaAluno;

    @Column(name = "cod_disciplina", insertable = false, updatable = false)
    private Integer codDisciplina;

    @Column(name = "cod_aluno", insertable = false, updatable = false)
    private Integer codAluno;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cod_disciplina", nullable = false)
    private Disciplina disciplina;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cod_aluno", nullable = false)
    private Aluno aluno;

    public AlunoDisciplina() {
    }

    public AlunoDisciplina(Integer codDisciplinaAluno, Disciplina disciplina, Aluno aluno) {
        this.codDisciplinaAluno = codDisciplinaAluno;
        this.disciplina = disciplina;
        this.aluno = aluno;
    }

    public Integer getCodDisciplinaAluno() {
        return codDisciplinaAluno;
    }

    public void setCodDisciplinaAluno(Integer codDisciplinaAluno) {
        this.codDisciplinaAluno = codDisciplinaAluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Integer getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public Integer getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(Integer codAluno) {
        this.codAluno = codAluno;
    }
}
