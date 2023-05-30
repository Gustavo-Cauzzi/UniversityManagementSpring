package com.gestao.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_curso")
    private Integer codCurso;

    @Column(name = "des_curso", unique = true, nullable = false)
    private String desCurso;

    @ManyToOne
    @JoinColumn(name = "cod_universidade", nullable = false)
    private Universidade universidade;

    public Curso() {
    }

    public Curso(Integer codCurso, String desCurso, Universidade universidade) {
        this.codCurso = codCurso;
        this.desCurso = desCurso;
        this.universidade = universidade;
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

    public Universidade getUniversidade() {
        return universidade;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }
}
