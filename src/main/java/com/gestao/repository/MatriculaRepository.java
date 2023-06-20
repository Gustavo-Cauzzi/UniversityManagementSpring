package com.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.domain.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

	void deleteAllByCodUniversidade(Integer codUniversidade);

	void deleteAllByCodCurso(Integer codCurso);

	void deleteAllByCodAluno(Integer codAluno);

}
