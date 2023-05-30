package com.gestao.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "universidades")
public class Universidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_universidade")
    private Integer codUniversidade;

    @Column(name = "des_universidade", unique = true, nullable = false)
    private String desUniversidade;

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
}
