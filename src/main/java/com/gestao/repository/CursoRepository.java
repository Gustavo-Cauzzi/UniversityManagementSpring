package com.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

	List<Curso> findByCodUniversidade(Integer codUniversidade);
	
	void deleteAllByCodUniversidade(Integer codUniversidade);
	
}
