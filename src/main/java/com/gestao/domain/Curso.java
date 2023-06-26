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

}
