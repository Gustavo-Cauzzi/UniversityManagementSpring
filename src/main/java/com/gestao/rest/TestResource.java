package com.gestao.rest;

import com.gestao.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/tests/")
public class TestResource {
    private final TestService testService;

    public TestResource(final TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public ResponseEntity<Map<String, Object>> applicationLogin() {
        return ResponseEntity.ok().build();
    }

}
