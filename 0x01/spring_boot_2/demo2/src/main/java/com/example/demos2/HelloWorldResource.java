package com.example.demo2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value="/messages")
public class HelloWorldResource {

    @GetMapping("/home")
    public String home() {
        return "PROJETO MAVEN (SPRING INITIALIZR) CRIADO COM SUCESSO !!!";
    }

}
