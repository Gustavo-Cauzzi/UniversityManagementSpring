package com.gestao.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cod_universidade", insertable = false, updatable = false)
    private Universidade universidade;

    @Column(name = "cod_universidade", nullable = false)
    private Integer codUniversidade;

    public Curso() {
    }

    public Curso(Integer codCurso, String desCurso, Integer codUniversidade) {
        this.codCurso = codCurso;
        this.desCurso = desCurso;
        this.codUniversidade = codUniversidade;
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

    public Integer getCodUniversidade() {
        return codUniversidade;
    }

    public void setCodUniversidade(Integer codUniversidade) {
        this.codUniversidade = codUniversidade;
    }
}
