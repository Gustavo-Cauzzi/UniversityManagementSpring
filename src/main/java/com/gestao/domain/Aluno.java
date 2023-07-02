package com.gestao.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "alunos")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_aluno")
	private Integer codAluno;

	@Column(name = "des_aluno", unique = true, nullable = false)
	private String desAluno;

	@JsonIgnoreProperties("aluno")
	@OneToMany
	@JoinColumn(name = "cod_aluno", insertable = false, updatable = false)
	private List<Matricula> matriculas;

	@JsonIgnoreProperties("aluno")
	@OneToMany
	@JoinColumn(name = "cod_aluno", insertable = false, updatable = false)
	private List<AlunoDisciplina> alunoDisciplinas;


	public Aluno() {
	}

	public Aluno(Integer codAluno, String desAluno) {
		this.codAluno = codAluno;
		this.desAluno = desAluno;
	}

	public Integer getCodAluno() {
		return codAluno;
	}

	public void setCodAluno(Integer codAluno) {
		this.codAluno = codAluno;
	}

	public String getDesAluno() {
		return desAluno;
	}

	public void setDesAluno(String desAluno) {
		this.desAluno = desAluno;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<AlunoDisciplina> getAlunoDisciplinas() {
		return alunoDisciplinas;
	}

	public void setAlunoDisciplinas(List<AlunoDisciplina> alunoDisciplinas) {
		this.alunoDisciplinas = alunoDisciplinas;
	}
}