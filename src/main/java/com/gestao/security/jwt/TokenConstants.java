package com.gestao.security.jwt;

public enum TokenConstants {
	SESSION("session"),
	AUTHORITIES("auth");
	private final String key;
	TokenConstants (final String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
}
