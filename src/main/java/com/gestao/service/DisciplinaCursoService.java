package com.gestao.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestao.domain.DisciplinaCurso;
import com.gestao.repository.DisciplinaCursoDAO;
import com.gestao.repository.DisciplinaCursoRepository;
import com.gestao.rest.vo.DisciplinaCursoVO;

@Service
public class DisciplinaCursoService {

	private final DisciplinaCursoRepository disciplinaCursoRepository;
	private final DisciplinaCursoDAO disciplinaCursoDAO;

	public DisciplinaCursoService(DisciplinaCursoRepository disciplinaCursoRepository,
			DisciplinaCursoDAO disciplinaCursoDAO) {
		this.disciplinaCursoRepository = disciplinaCursoRepository;
		this.disciplinaCursoDAO = disciplinaCursoDAO;
	}

	public List<DisciplinaCurso> findAll() {
		return this.disciplinaCursoRepository.findAll();
	}

	public List<DisciplinaCursoVO> findByCodCurso(Integer codCurso) {
		return this.disciplinaCursoDAO.findDisciplinasCurso(codCurso);
	}

	public DisciplinaCurso save(final DisciplinaCurso disciplinaCurso) {
		return this.disciplinaCursoRepository.save(disciplinaCurso);
	}

	public ResponseEntity<Void> deleteDisciplinaCurso(final Integer codDisciplinaCurso) {
		this.disciplinaCursoRepository.deleteById(codDisciplinaCurso);
		return ResponseEntity.noContent().build();
	}

}
