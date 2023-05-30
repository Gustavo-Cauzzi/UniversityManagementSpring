package com.gestao.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos_disciplinas")
public class AlunoDisciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_disciplina_aluno")
    private Integer codDisciplinaAluno;

    @ManyToOne
    @JoinColumn(name = "cod_disciplina", nullable = false)
    private Disciplina disciplina;

    @ManyToOne
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
}
