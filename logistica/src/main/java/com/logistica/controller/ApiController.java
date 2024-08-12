package com.logistica.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/mensagem")
    public String getMensagem() {
        return "Olá, esta é uma mensagem da API REST!";
    }
}

