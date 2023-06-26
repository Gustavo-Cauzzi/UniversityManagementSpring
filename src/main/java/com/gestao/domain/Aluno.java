package com.gestao.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_aluno")
	private Integer codAluno;

	@Column(name = "des_aluno", unique = true, nullable = false)
	private String desAluno;

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

}