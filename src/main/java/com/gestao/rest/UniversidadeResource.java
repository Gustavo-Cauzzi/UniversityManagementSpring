package com.gestao.rest;

import com.gestao.domain.Universidade;
import com.gestao.security.SecurityUtils;
import com.gestao.service.UniversidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/universidade")
public class UniversidadeResource {
    private final UniversidadeService universidadeService;

    public UniversidadeResource(UniversidadeService universidadeService) {
        this.universidadeService = universidadeService;
    }

    @GetMapping
    public ResponseEntity<List<Universidade>> findAll () {
        SecurityUtils.getSession();
        return ResponseEntity.ok(this.universidadeService.findAll());
    }
}
