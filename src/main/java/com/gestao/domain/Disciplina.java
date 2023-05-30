package com.gestao.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "disciplina")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_disciplina")
    private Integer codDisciplina;

    @Column(name = "des_disciplina")
    private String desDisciplina;

    public Disciplina() {
    }

    public Disciplina(Integer codDisciplina, String desDisciplina) {
        this.codDisciplina = codDisciplina;
        this.desDisciplina = desDisciplina;
    }

    public Integer getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public String getDesDisciplina() {
        return desDisciplina;
    }

    public void setDesDisciplina(String desDisciplina) {
        this.desDisciplina = desDisciplina;
    }
}
