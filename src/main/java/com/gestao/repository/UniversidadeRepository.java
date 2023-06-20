package com.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.domain.Universidade;

public interface UniversidadeRepository extends JpaRepository<Universidade, Integer> {
	List<Universidade> findAllByDesUniversidade(String desUniversidade);
}
