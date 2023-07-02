package com.gestao.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "universidades")
public class Universidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_universidade")
    private Integer codUniversidade;

    @Column(name = "des_universidade", unique = true, nullable = false)
    private String desUniversidade;

    @OneToMany
    @JoinColumn(name = "cod_universidade", insertable = false, updatable = false)
    @JsonIgnoreProperties("universidade")
    private List<UniversidadeCurso> universidadeCurso;


    public Universidade(Integer codUniversidade, String desUniversidade) {
        this.codUniversidade = codUniversidade;
        this.desUniversidade = desUniversidade;
    }

    public Universidade() {
    }

    public Integer getCodUniversidade() {
        return codUniversidade;
    }

    public void setCodUniversidade(Integer codUniversidade) {
        this.codUniversidade = codUniversidade;
    }

    public String getDesUniversidade() {
        return desUniversidade;
    }

    public void setDesUniversidade(String desUniversidade) {
        this.desUniversidade = desUniversidade;
    }

    public List<UniversidadeCurso> getUniversidadeCurso() {
        return universidadeCurso;
    }

    public void setUniversidadeCurso(List<UniversidadeCurso> universidadeCurso) {
        this.universidadeCurso = universidadeCurso;
    }
}
