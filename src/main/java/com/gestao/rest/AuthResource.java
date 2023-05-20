package com.gestao.rest;

import com.gestao.service.AuthService;
import com.gestao.utils.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthResource {
    private final AuthService authService;

    public AuthResource(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public ResponseEntity<GenericResponse> login() {
        return ResponseEntity.ok(GenericResponse.create().put("session", this.authService.createJwt()));
    }
}
