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

import com.gestao.domain.Curso;
import com.gestao.service.CursoService;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoResource {

	private final CursoService cursoService;

	public CursoResource(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {
		return ResponseEntity.ok(this.cursoService.findAll());
	}

	@GetMapping("/{codUniversidade}")
	public ResponseEntity<List<Curso>> cursoUniv(@PathVariable final Integer codUniversidade) {
		return ResponseEntity.ok(this.cursoService.findCursoUniv(codUniversidade));
	}

	@GetMapping("/findOne/{codMatricula}")
	public ResponseEntity<Optional<Curso>> findOne(@PathVariable final Integer codCurso) {
		return ResponseEntity.ok(this.cursoService.findOne(codCurso));
	}

	@PostMapping
	public Curso save(@RequestBody Curso curso) {
		return this.cursoService.save(curso);
	}

	@DeleteMapping("/{codCurso}")
	public ResponseEntity<Void> deletePost(@PathVariable final Integer codCurso) {
		return this.cursoService.deleteCurso(codCurso);
	}
}
