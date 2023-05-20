package com.gestao.security;

import com.gestao.security.jwt.TokenConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;
import java.util.Optional;

/**
 * Utility class for Spring Security.
 */
public final class SecurityUtils {
    private SecurityUtils() {
    }
    public static Optional<Long> getSession() {
        return Optional.ofNullable((Long) extract(TokenConstants.SESSION.getKey()));
    }

    private static Object extract(final String key) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication) || !(authentication instanceof WebAutheticationToken) || Objects.isNull(authentication.getDetails())) {
            return null;
        }
        return ((WebAutheticationToken) authentication).getDetails().get(key);
    }


}
