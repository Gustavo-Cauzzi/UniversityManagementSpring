package com.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.domain.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

}
