package com.gestao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestao.domain.Curso;
import com.gestao.repository.CursoRepository;
import com.gestao.repository.DisciplinaCursoRepository;
import com.gestao.repository.MatriculaRepository;

@Service
public class CursoService {

	private final CursoRepository cursoRepository;
	private final DisciplinaCursoRepository disciplinaCursoRepository;
	private final MatriculaRepository matriculaRepository;

	public CursoService(CursoRepository cursoRepository, DisciplinaCursoRepository disciplinaCursoRepository,
			MatriculaRepository matriculaRepository) {
		this.cursoRepository = cursoRepository;
		this.disciplinaCursoRepository = disciplinaCursoRepository;
		this.matriculaRepository = matriculaRepository;
	}

	public List<Curso> findAll() {
		return this.cursoRepository.findAll();
	}

	public Optional<Curso> findOne(final Integer codCurso) {
		return this.cursoRepository.findById(codCurso);
	}

	public Curso save(final Curso curso) {
		return this.cursoRepository.save(curso);
	}

	public ResponseEntity<Void> deleteCurso(final Integer codCurso) {
		this.disciplinaCursoRepository.deleteAllByCodCurso(codCurso);
		this.matriculaRepository.deleteAllByCodCurso(codCurso);
		this.cursoRepository.deleteById(codCurso);
		return ResponseEntity.accepted().build();
	}
}
