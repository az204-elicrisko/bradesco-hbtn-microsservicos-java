package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/messages")
public class MessageResource {
@GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
     
      return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";

    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "user", required = false) String user,
                       @RequestParam(value = "password", required = false) String password) {
        
        // Verifica se user ou password estão em branco ou não informados
        if (user == null || user.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            return "USUÁRIO E SENHA NÃO INFORMADOS";
        }
        
        // Verifica se user ou password têm mais que 15 caracteres
        if (user.length() > 15 || password.length() > 15) {
            return "USUÁRIO E SENHA INVÁLIDOS";
        }
        
        // Se passou por todas as validações
        return "LOGIN EFETUADO COM SUCESSO !!!";
    }
}
