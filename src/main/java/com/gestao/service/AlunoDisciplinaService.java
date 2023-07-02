package com.gestao.service;

import com.gestao.domain.AlunoDisciplina;
import com.gestao.repository.AlunoDisciplinaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoDisciplinaService {
	private final AlunoDisciplinaRepository alunoDisciplinaRepository;

	public AlunoDisciplinaService(AlunoDisciplinaRepository alunoDisciplinaRepository) {
		this.alunoDisciplinaRepository = alunoDisciplinaRepository;
	}

	public List<AlunoDisciplina> findAll() {
		return this.alunoDisciplinaRepository.findAll();
	}

	public AlunoDisciplina save(final AlunoDisciplina alunoDisciplina) {
		return this.alunoDisciplinaRepository.save(alunoDisciplina);
	}

	public ResponseEntity<Void> deleteAlunoDisciplina(final Integer codAlunoDisciplina) {
		this.alunoDisciplinaRepository.deleteById(codAlunoDisciplina);
		return ResponseEntity.accepted().build();
	}
}
