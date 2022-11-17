package com.andygomez.main.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @Value("${mensaje.bienvenida}")
    private String mensajeBienvenida;
    
    @GetMapping("/")
    public String saludo(){return mensajeBienvenida;
    }
    
}
