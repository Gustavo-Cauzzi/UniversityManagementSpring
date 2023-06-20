package com.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	List<Aluno> findAllByCodCurso(Integer codCurso);
	
}
