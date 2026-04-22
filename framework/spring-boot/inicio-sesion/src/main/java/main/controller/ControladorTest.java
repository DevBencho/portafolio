package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


//anotacion de controlador, como era prueba no use RestController
@Controller
//esta clase la cree para probar MVC de controlador en particular a una vista en particular
//aplicando la iynyeccion de dependencias con model
public class ControladorTest {
    @GetMapping("/test")
    //Aca se realizo se paso como parametro un objeto model
    public String test(Model model){
        model.addAttribute("name", "Proyecto de Inicio Sesion");
        model.addAttribute("tech", "Java y Spring");
        model.addAttribute("dev", "DevBencho");
        return "test";
    }
}
