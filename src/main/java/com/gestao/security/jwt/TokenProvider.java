package com.gestao.security.jwt;

import com.gestao.security.WebAutheticationToken;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.KeyException;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class TokenProvider {

    private final Logger log = LoggerFactory.getLogger(TokenProvider.class);
    private final Key key;
    private final JwtParser jwtParser;
    private final long tokenValidityInMilliseconds;

    public TokenProvider(final TokenProps props) {
        byte[] keyBytes;
        String secret = props.getSecret();
        if (!ObjectUtils.isEmpty(secret)) {
            keyBytes = Decoders.BASE64.decode(secret);
        } else {
            throw new KeyException("Chave não encontrada no arquivo de propriedades.");
        }
        key = Keys.hmacShaKeyFor(keyBytes);
        jwtParser = Jwts.parserBuilder().setSigningKey(key).build();
        this.tokenValidityInMilliseconds = 1_000 * props.getTimeTokenInSeconds();
    }

	public String createToken(final Long session) {
        long now = (new Date()).getTime();
        Date validity;
        validity = new Date(now + this.tokenValidityInMilliseconds);

        return Jwts
            .builder()
            .setSubject(String.valueOf(session))
            .claim(TokenConstants.AUTHORITIES.getKey() , "admin")
            .claim(TokenConstants.SESSION.getKey() , session)
            .signWith(key, SignatureAlgorithm.HS512)
            .setExpiration(validity)
            .compact();
    }

    public Authentication getAuthentication(final String token) {
        Claims claims = jwtParser.parseClaimsJws(token).getBody();

        Collection<? extends GrantedAuthority> authorities = Arrays
            .stream(claims.get(TokenConstants.AUTHORITIES.getKey()).toString().split(","))
            .filter(auth -> !auth.trim().isEmpty())
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "123123", authorities);

        return new WebAutheticationToken(principal, authorities, token, claims);
    }

    public boolean validateToken(final String authToken) {
        try {
            jwtParser.parseClaimsJws(authToken);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            log.info("Invalid JWT token.");
            log.trace("Invalid JWT token trace.", e);
        }
        return false;
    }

}
