package com.gestao.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestao.domain.AlunoDisciplina;
import com.gestao.repository.AlunoDisciplinaDAO;
import com.gestao.repository.AlunoDisciplinaRepository;
import com.gestao.rest.vo.AlunoDisciplinaVO;

@Service
public class AlunoDisciplinaService {
	private final AlunoDisciplinaRepository alunoDisciplinaRepository;
	private final AlunoDisciplinaDAO alunoDisciplinaDAO;

	public AlunoDisciplinaService(AlunoDisciplinaRepository alunoDisciplinaRepository,
			AlunoDisciplinaDAO alunoDisciplinaDAO) {
		this.alunoDisciplinaRepository = alunoDisciplinaRepository;
		this.alunoDisciplinaDAO = alunoDisciplinaDAO;
	}

	public List<AlunoDisciplina> findAll() {
		return this.alunoDisciplinaRepository.findAll();
	}

	public List<AlunoDisciplinaVO> findByAluno(final Integer codAluno) {
		return this.alunoDisciplinaDAO.findByAluno(codAluno);
	}

	public AlunoDisciplina save(final AlunoDisciplina alunoDisciplina) {
		return this.alunoDisciplinaRepository.save(alunoDisciplina);
	}

	public ResponseEntity<Void> deleteAlunoDisciplina(final Integer codAlunoDisciplina) {
		this.alunoDisciplinaRepository.deleteById(codAlunoDisciplina);
		return ResponseEntity.accepted().build();
	}
}
