package com.gestao.repository;

import com.gestao.domain.DisciplinaCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaCursoRepository extends JpaRepository<DisciplinaCurso, Integer> {

	void findAllByCodCurso(Integer codCurso);
	
	void deleteAllByCodCurso(Integer codCurso);
	
	void deleteAllByCodDisciplina(Integer codDisciplina);
	
}
