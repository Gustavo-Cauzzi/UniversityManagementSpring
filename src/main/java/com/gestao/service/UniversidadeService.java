package com.gestao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestao.domain.Universidade;
import com.gestao.repository.CursoRepository;
import com.gestao.repository.MatriculaRepository;
import com.gestao.repository.UniversidadeRepository;

@Service
public class UniversidadeService {
    private final UniversidadeRepository universidadeRepository;
    private final CursoRepository cursoRepository;
    private final MatriculaRepository matriculaRepository;

    public UniversidadeService(UniversidadeRepository universidadeRepository, CursoRepository cursoRepository, MatriculaRepository matriculaRepository) {
        this.universidadeRepository = universidadeRepository;
        this.cursoRepository = cursoRepository;
        this.matriculaRepository = matriculaRepository;
    }

    public List<Universidade> findAll() {
        return this.universidadeRepository.findAll();
    }

    public Optional<Universidade> findOne(final Integer codUniversidade) {
        return this.universidadeRepository.findById(codUniversidade);
    }

    public Universidade save(final Universidade universidade) {
        return this.universidadeRepository.save(universidade);
    }

}
