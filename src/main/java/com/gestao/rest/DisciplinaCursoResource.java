package com.gestao.rest;

import com.gestao.domain.DisciplinaCurso;
import com.gestao.service.DisciplinaCursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/disciplinaCurso")
public class DisciplinaCursoResource {

	private final DisciplinaCursoService disciplinaCursoService;

	public DisciplinaCursoResource(DisciplinaCursoService disciplinaCursoService) {
		this.disciplinaCursoService = disciplinaCursoService;
	}

	@GetMapping
	public ResponseEntity<List<DisciplinaCurso>> findAll() {
		return ResponseEntity.ok(this.disciplinaCursoService.findAll());
	}

	@PostMapping
	public DisciplinaCurso save(@RequestBody DisciplinaCurso disciplinaCurso) {
		return this.disciplinaCursoService.save(disciplinaCurso);
	}

	@DeleteMapping("/{codDisciplinaCurso}")
	public ResponseEntity<Void> deletePost(@PathVariable Integer codDisciplinaCurso) {
		return this.disciplinaCursoService.deleteDisciplinaCurso(codDisciplinaCurso);
	}
}
