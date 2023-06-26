package com.gestao.rest;

import com.gestao.domain.UniversidadeCurso;
import com.gestao.service.UniversidadeCursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/universidadeCurso")
public class UniversidadeCursoResource {
    private final UniversidadeCursoService universidadeCursoService;

    public UniversidadeCursoResource(UniversidadeCursoService universidadeCursoService) {
        this.universidadeCursoService = universidadeCursoService;
    }

    @GetMapping
    public ResponseEntity<List<UniversidadeCurso>> findAll () {
        return ResponseEntity.ok(this.universidadeCursoService.findAll());
    }

    @PostMapping
    public ResponseEntity<UniversidadeCurso> save (@RequestBody UniversidadeCurso entity) {
        return ResponseEntity.ok(this.universidadeCursoService.save(entity));
    }
}
