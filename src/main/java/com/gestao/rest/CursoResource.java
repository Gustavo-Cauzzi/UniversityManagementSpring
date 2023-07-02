package com.gestao.rest;

import com.gestao.domain.Curso;
import com.gestao.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
