package com.gestao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
