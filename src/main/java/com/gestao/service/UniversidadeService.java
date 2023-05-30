package com.gestao.service;

import com.gestao.domain.Universidade;
import com.gestao.repository.UniversidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversidadeService {
    private final UniversidadeRepository universidadeRepository;

    public UniversidadeService(UniversidadeRepository universidadeRepository) {
        this.universidadeRepository = universidadeRepository;
    }

    public List<Universidade> findAll () {
        return this.universidadeRepository.findAll();
    }
}
