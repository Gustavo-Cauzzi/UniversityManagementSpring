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

import com.gestao.domain.DisciplinaCurso;
import com.gestao.rest.vo.DisciplinaCursoVO;
import com.gestao.service.DisciplinaCursoService;

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
	
	@GetMapping("/{codCurso}")
	public ResponseEntity<List<DisciplinaCursoVO>> findByCurso(@PathVariable final Integer codCurso) {
		return ResponseEntity.ok(this.disciplinaCursoService.findByCodCurso(codCurso));
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
