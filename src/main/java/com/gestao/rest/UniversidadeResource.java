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

import com.gestao.domain.Universidade;
import com.gestao.service.UniversidadeService;

@RestController
@RequestMapping("/api/v1/universidade")
public class UniversidadeResource {
	private final UniversidadeService universidadeService;

	public UniversidadeResource(UniversidadeService universidadeService) {
		this.universidadeService = universidadeService;
	}

	@GetMapping
	public ResponseEntity<List<Universidade>> findAll() {
		return ResponseEntity.ok(this.universidadeService.findAll());
	}

	@GetMapping("{codUniversidade}")
	public ResponseEntity<Optional<Universidade>> findOne(@PathVariable final Integer codUniversidade) {
		return ResponseEntity.ok(this.universidadeService.findOne(codUniversidade));
	}

	@PostMapping
	public Universidade save(@RequestBody Universidade universidade) {
		return this.universidadeService.save(universidade);
	}
}
