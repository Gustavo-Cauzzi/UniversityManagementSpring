package com.gestao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestao.domain.Disciplina;
import com.gestao.repository.AlunoDisciplinaRepository;
import com.gestao.repository.DisciplinaCursoRepository;
import com.gestao.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	private final DisciplinaRepository disciplinaRepository;
	private final DisciplinaCursoRepository disciplinaCursoRepository;
	private final AlunoDisciplinaRepository alunoDisciplinaRepository;

	public DisciplinaService(DisciplinaRepository disciplinaRepository,
			DisciplinaCursoRepository disciplinaCursoRepository, AlunoDisciplinaRepository alunoDisciplinaRepository) {
		this.disciplinaRepository = disciplinaRepository;
		this.disciplinaCursoRepository = disciplinaCursoRepository;
		this.alunoDisciplinaRepository = alunoDisciplinaRepository;
	}

	public List<Disciplina> findAll() {
		return this.disciplinaRepository.findAll();

	}

	public Optional<Disciplina> findOne(final Integer codDisciplina) {
		return this.disciplinaRepository.findById(codDisciplina);
	}

	public Disciplina save(final Disciplina disciplina) {
		return this.disciplinaRepository.save(disciplina);
	}

	public ResponseEntity<Void> deleteDisciplina(final Integer codDisciplina) {
		this.disciplinaCursoRepository.deleteAllByCodDisciplina(codDisciplina);
		this.alunoDisciplinaRepository.deleteAllByCodDisciplina(codDisciplina);
		this.disciplinaRepository.deleteById(codDisciplina);
		return ResponseEntity.accepted().build();
	}
}
