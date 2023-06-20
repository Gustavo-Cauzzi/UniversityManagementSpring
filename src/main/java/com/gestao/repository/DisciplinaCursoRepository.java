package com.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.domain.DisciplinaCurso;

public interface DisciplinaCursoRepository extends JpaRepository<DisciplinaCurso, Integer> {

	void findAllByCodCurso(Integer codCurso);
	
	void deleteAllByCodCurso(Integer codCurso);
	
	void deleteAllByCodDisciplina(Integer codDisciplina);
	
}
