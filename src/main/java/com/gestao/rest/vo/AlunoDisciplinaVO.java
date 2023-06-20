package com.gestao.rest.vo;

import java.io.Serializable;

public class AlunoDisciplinaVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 572994257710528435L;

	private Integer codAluno;

	private String desAluno;

	private Integer codDisciplina;

	private Integer tipDisciplina;

	public AlunoDisciplinaVO() {
		// Empty Constructor
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

	public Integer getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(Integer codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public Integer getTipDisciplina() {
		return tipDisciplina;
	}

	public void setTipDisciplina(Integer tipDisciplina) {
		this.tipDisciplina = tipDisciplina;
	}

}
