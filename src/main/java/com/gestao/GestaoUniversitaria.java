package com.gestao;

import com.gestao.security.SecurityConfig;
import com.gestao.security.jwt.JWTFilter;
import com.gestao.security.jwt.TokenProps;
import com.gestao.security.jwt.TokenProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

;import java.util.Scanner;

@SpringBootApplication
public class GestaoUniversitaria {

    public static void main(final String[] args) {
        SpringApplication.run(GestaoUniversitaria.class, args);
        System.out.println("otho");
        Scanner sc = new Scanner(System.in);
        String teste = sc.next();
        System.out.println(teste);
    }

}
