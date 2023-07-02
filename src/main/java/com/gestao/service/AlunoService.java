package com.gestao.service;

import com.gestao.domain.Aluno;
import com.gestao.repository.AlunoDisciplinaRepository;
import com.gestao.repository.AlunoRepository;
import com.gestao.repository.MatriculaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
	private final AlunoRepository alunoRepository;
	private final AlunoDisciplinaRepository alunoDisciplinaRepository;
	private final MatriculaRepository matriculaRepository;

	public AlunoService(AlunoRepository alunoRepository, AlunoDisciplinaRepository alunoDisciplinaRepository, MatriculaRepository matriculaRepository) {
		this.alunoRepository = alunoRepository;
		this.alunoDisciplinaRepository = alunoDisciplinaRepository;
		this.matriculaRepository = matriculaRepository;
	}

	public List<Aluno> findAll() {
		return this.alunoRepository.findAll();
	}
	
	public Optional<Aluno> findOne(final Integer codAluno) {
		return this.alunoRepository.findById(codAluno);
	}

	public Aluno save(final Aluno aluno) {
		return this.alunoRepository.save(aluno);
	}

	public ResponseEntity<Void> deleteAluno(final Integer codAluno) {
		this.alunoDisciplinaRepository.deleteAllByCodAluno(codAluno);
		this.matriculaRepository.deleteAllByCodAluno(codAluno);
		this.alunoRepository.deleteById(codAluno);
		return ResponseEntity.noContent().build();
	}
}
