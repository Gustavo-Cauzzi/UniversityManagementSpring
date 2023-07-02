package com.gestao.rest;

import com.gestao.domain.AlunoDisciplina;
import com.gestao.service.AlunoDisciplinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@PostMapping
	public AlunoDisciplina save(@RequestBody AlunoDisciplina alunoDisciplina) {
		return this.alunoDisciplinaService.save(alunoDisciplina);
	}

	@DeleteMapping("/{codAlunoDisciplina}")
	public ResponseEntity<Void> deletePost(@PathVariable Integer codAlunoDisciplina) {
		return this.alunoDisciplinaService.deleteAlunoDisciplina(codAlunoDisciplina);
	}
}
