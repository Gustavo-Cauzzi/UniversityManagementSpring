package com.gestao.service;

import com.gestao.domain.UniversidadeCurso;
import com.gestao.repository.UniversidadeCursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversidadeCursoService {

    private final UniversidadeCursoRepository universidadeCursoRepository;

    public UniversidadeCursoService(UniversidadeCursoRepository universidadeCursoRepository) {
        this.universidadeCursoRepository = universidadeCursoRepository;
    }

    public List<UniversidadeCurso> findAll () {
        return universidadeCursoRepository.findAll();
    }

    public UniversidadeCurso save (UniversidadeCurso entity) {
        return universidadeCursoRepository.save(entity);
    }
}
