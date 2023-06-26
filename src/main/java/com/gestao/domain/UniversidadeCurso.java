package com.gestao.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "universidade_curso")
public class UniversidadeCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_universidade_curso")
    private Integer codUniversidadeCurso;

    @Column(name = "cod_curso")
    private Integer codCurso;

    @Column(name = "cod_universidade")
    private Integer codUniversidade;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cod_universidade", insertable = false, updatable = false)
    private Universidade universidade;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cod_curso", insertable = false, updatable = false)
    private Curso curso;

    public UniversidadeCurso(Integer codUniversidadeCurso, Integer codCurso, Integer codUniversidade, Universidade universidade, Curso curso) {
        this.codUniversidadeCurso = codUniversidadeCurso;
        this.codCurso = codCurso;
        this.codUniversidade = codUniversidade;
        this.universidade = universidade;
        this.curso = curso;
    }

    public UniversidadeCurso() {

    }

    public Integer getCodUniversidadeCurso() {
        return codUniversidadeCurso;
    }

    public void setCodUniversidadeCurso(Integer codUniversidadeCurso) {
        this.codUniversidadeCurso = codUniversidadeCurso;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public Integer getCodUniversidade() {
        return codUniversidade;
    }

    public void setCodUniversidade(Integer codUniversidade) {
        this.codUniversidade = codUniversidade;
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
}
