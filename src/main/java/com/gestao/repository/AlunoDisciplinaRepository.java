package com.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.domain.AlunoDisciplina;

public interface AlunoDisciplinaRepository extends JpaRepository<AlunoDisciplina, Integer> {

	void deleteAllByCodDisciplina(Integer codDisciplina);
	
	void deleteAllByCodAluno(Integer codAluno);
	
}
