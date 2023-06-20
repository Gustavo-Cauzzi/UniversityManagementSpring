package com.gestao.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.domain.Disciplina;
import com.gestao.service.DisciplinaService;

@RestController
@RequestMapping("/api/v1/disciplina")
public class DisciplinaResource {

	private final DisciplinaService disciplinaService;

	public DisciplinaResource(DisciplinaService disciplinaService) {
		this.disciplinaService = disciplinaService;
	}

	@GetMapping
	public ResponseEntity<List<Disciplina>> findAll() {
		return ResponseEntity.ok(this.disciplinaService.findAll());
	}

	@GetMapping("{codDisciplina}")
	public ResponseEntity<Optional<Disciplina>> findOne(@PathVariable final Integer codDisciplina) {
		return ResponseEntity.ok(this.disciplinaService.findOne(codDisciplina));
	}

	@PostMapping
	public Disciplina save(@RequestBody Disciplina disciplina) {
		return this.disciplinaService.save(disciplina);
	}

	@DeleteMapping("/{codDisciplina}")
	public ResponseEntity<Void> deletePost(@PathVariable Integer codDisciplina) {
		return this.disciplinaService.deleteDisciplina(codDisciplina);
	}

}
