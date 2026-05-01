package dev.reux.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorRaiz {
    @GetMapping("/")
    public String redireccionInicial() {
        // Al entrar a la raíz, forzamos al navegador a ir a la ruta del registro
        return "redirect:/api/usuarios/register";
    }
}
