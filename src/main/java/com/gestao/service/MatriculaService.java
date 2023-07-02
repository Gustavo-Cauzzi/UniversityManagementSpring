package com.gestao.service;

import com.gestao.domain.Matricula;
import com.gestao.repository.MatriculaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

	private final MatriculaRepository matriculaRepository;

	public MatriculaService(MatriculaRepository matriculaRepository) {
		this.matriculaRepository = matriculaRepository;
	}

	public List<Matricula> findAll() {
		return this.matriculaRepository.findAll();
	}

	public Optional<Matricula> findOne(final Integer codMatricula) {
		return this.matriculaRepository.findById(codMatricula);
	}

	public Matricula save(final Matricula matricula) {
		return this.matriculaRepository.save(matricula);
	}

	public ResponseEntity<Void> deleteMatricula(final Integer codMatricula) {
		this.matriculaRepository.deleteById(codMatricula);
		return ResponseEntity.noContent().build();
	}

}
