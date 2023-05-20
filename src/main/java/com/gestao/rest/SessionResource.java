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
@RequestMapping("/api/v1/session")
public class SessionResource {
    private final AuthService authService;

    public SessionResource(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/current")
    public ResponseEntity<Map<String, Object>> currentAuthentication() {
        HashMap<String, Object> body = new HashMap<>();
        body.put("auth", this.authService.getDefaults());
        return ResponseEntity.ok(body);
    }
}
