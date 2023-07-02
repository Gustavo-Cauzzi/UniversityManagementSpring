package com.gestao.repository;

import com.gestao.domain.Universidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversidadeRepository extends JpaRepository<Universidade, Integer> {
	List<Universidade> findAllByDesUniversidade(String desUniversidade);
}
