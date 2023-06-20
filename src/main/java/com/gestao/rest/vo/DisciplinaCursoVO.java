package com.gestao.rest.vo;

import java.io.Serializable;

public class DisciplinaCursoVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6616886802791934030L;
	private Integer codCurso;

	private Integer codDisciplina;

	private String desCurso;

	private Integer tipDisciplina;

	public DisciplinaCursoVO() {
		// Empty Constructor
	}

	public Integer getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(Integer codCurso) {
		this.codCurso = codCurso;
	}

	public Integer getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(Integer codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getDesCurso() {
		return desCurso;
	}

	public void setDesCurso(String desCurso) {
		this.desCurso = desCurso;
	}

	public Integer getTipDisciplina() {
		return tipDisciplina;
	}

	public void setTipDisciplina(Integer tipDisciplina) {
		this.tipDisciplina = tipDisciplina;
	}

}
