package com.gestao.repository;

import com.gestao.domain.AlunoDisciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoDisciplinaRepository extends JpaRepository<AlunoDisciplina, Integer> {

	void deleteAllByCodDisciplina(Integer codDisciplina);
	
	void deleteAllByCodAluno(Integer codAluno);
	
}
