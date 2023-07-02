package com.gestao.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_curso")
    private Integer codCurso;

    @Column(name = "des_curso", unique = true, nullable = false)
    private String desCurso;

    @JsonIgnoreProperties("curso")
    @OneToMany
    @JoinColumn(name = "cod_curso", insertable = false, updatable = false)
    private List<DisciplinaCurso> disciplinaCurso;

    @JsonIgnoreProperties("curso")
    @OneToMany
    @JoinColumn(name = "cod_curso", insertable = false, updatable = false)
    private List<Matricula> matriculas;

    public Curso() {
    }

    public Curso(Integer codCurso, String desCurso, Integer codUniversidade) {
        this.codCurso = codCurso;
        this.desCurso = desCurso;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public String getDesCurso() {
        return desCurso;
    }

    public void setDesCurso(String desCurso) {
        this.desCurso = desCurso;
    }

    public List<DisciplinaCurso> getDisciplinaCurso() {
        return disciplinaCurso;
    }

    public void setDisciplinaCurso(List<DisciplinaCurso> disciplinaCurso) {
        this.disciplinaCurso = disciplinaCurso;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
