package com.gestao.repository;

import com.gestao.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {

	void deleteAllByCodCurso(Integer codCurso);

	void deleteAllByCodAluno(Integer codAluno);

}
