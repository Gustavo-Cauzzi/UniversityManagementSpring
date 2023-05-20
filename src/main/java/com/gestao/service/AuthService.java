package com.gestao.service;

import com.gestao.security.SecurityUtils;
import com.gestao.security.jwt.TokenProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class AuthService {

	private TokenProvider tokenProvider;

	public AuthService(TokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}

	public Optional<Long> getDefaults() {
		return SecurityUtils.getSession();
	}

	public String createJwt() {
		return tokenProvider.createToken(Instant.now().toEpochMilli());
	}
}
