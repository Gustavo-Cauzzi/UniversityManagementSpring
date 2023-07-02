package com.gestao.rest;

import com.gestao.domain.Universidade;
import com.gestao.service.UniversidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
