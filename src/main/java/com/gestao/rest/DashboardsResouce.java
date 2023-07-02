package com.gestao.rest;


import com.gestao.service.UniversidadeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dashboards")
public class DashboardsResouce {
    private final UniversidadeService universidadeService;

    public DashboardsResouce(UniversidadeService universidadeService) {
        this.universidadeService = universidadeService;
    }

}
