package com.gestao.rest;

import com.gestao.domain.Matricula;
import com.gestao.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/matricula")
public class MatriculaResource {

	private final MatriculaService matriculaService;

	public MatriculaResource(MatriculaService matriculaService) {
		this.matriculaService = matriculaService;
	}

	@GetMapping
	public ResponseEntity<List<Matricula>> findAll() {
		return ResponseEntity.ok(this.matriculaService.findAll());
	}

	@GetMapping("{codMatricula}")
	public ResponseEntity<Optional<Matricula>> findOne(@PathVariable final Integer codMatricula) {
		return ResponseEntity.ok(this.matriculaService.findOne(codMatricula));
	}

	@PostMapping
	public Matricula save(@RequestBody Matricula matricula) {
		return this.matriculaService.save(matricula);
	}

	@DeleteMapping("/{codMatricula}")
	public ResponseEntity<Void> deletePost(@PathVariable Integer codMatricula) {
		return this.matriculaService.deleteMatricula(codMatricula);
	}

}
