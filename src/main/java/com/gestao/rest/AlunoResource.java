package com.gestao.rest;

import com.gestao.domain.Aluno;
import com.gestao.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/aluno")
public class AlunoResource {
	private final AlunoService alunoService;

	public AlunoResource(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		return ResponseEntity.ok(this.alunoService.findAll());
	}
	
	@GetMapping("/{codAluno}")
	public ResponseEntity<Optional<Aluno>> findOne(@PathVariable final Integer codAluno) {
		return ResponseEntity.ok(this.alunoService.findOne(codAluno));
	}

	@PostMapping
	public Aluno save(@RequestBody Aluno aluno) {
		return this.alunoService.save(aluno);
	}

	@DeleteMapping("/{codAluno}")
	public ResponseEntity<Void> deletePost(@PathVariable Integer codAluno) {
		return this.alunoService.deleteAluno(codAluno);
	}
}
