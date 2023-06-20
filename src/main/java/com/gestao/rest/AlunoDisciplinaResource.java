package com.gestao.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.domain.AlunoDisciplina;
import com.gestao.rest.vo.AlunoDisciplinaVO;
import com.gestao.service.AlunoDisciplinaService;

@RestController
@RequestMapping("/api/v1/alunoDisciplina")
public class AlunoDisciplinaResource {

	private final AlunoDisciplinaService alunoDisciplinaService;

	public AlunoDisciplinaResource(AlunoDisciplinaService alunoDisciplinaService) {
		this.alunoDisciplinaService = alunoDisciplinaService;
	}

	@GetMapping
	public ResponseEntity<List<AlunoDisciplina>> findAll() {
		return ResponseEntity.ok(this.alunoDisciplinaService.findAll());
	}
	
	@GetMapping("{codAluno}")
	public ResponseEntity<List<AlunoDisciplinaVO>> findByAluno(final Integer codAluno) {
		return ResponseEntity.ok(this.alunoDisciplinaService.findByAluno(codAluno));
	}

	@PostMapping
	public AlunoDisciplina save(@RequestBody AlunoDisciplina alunoDisciplina) {
		return this.alunoDisciplinaService.save(alunoDisciplina);
	}

	@DeleteMapping("/{codAlunoDisciplina}")
	public ResponseEntity<Void> deletePost(@PathVariable Integer codAlunoDisciplina) {
		return this.alunoDisciplinaService.deleteAlunoDisciplina(codAlunoDisciplina);
	}
}
