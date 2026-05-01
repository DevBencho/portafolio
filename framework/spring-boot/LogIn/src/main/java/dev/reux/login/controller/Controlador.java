package dev.reux.login.controller;
import dev.reux.login.DTOs.UsuariosDTO;
import dev.reux.login.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


// se cambio de @RestController a @Controller, asi el insertarUsuario ya no devuelve un
// objeto UsuariosDTO convertido a JSON, sino un String que representa una instrucción de navegación.
@Controller
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Esto permite que cualquier origen (como mi HTML) le envíe datos
public class Controlador {

    //inyeccion de dependencias para invocacion de los metodos del servicio
    @Autowired
    private UsuariosService service;

    @GetMapping("/")
    public String inicio() {
        // Esto redirigirá automáticamente al usuario al listado tras loguearse
        return "redirect:/api/usuarios/register";
    }

    // Este metodo muestra el HTML del formulario, es decir envia a la pagina del formulario
    @GetMapping("/register")
    public String mostrarFormulario() {
        return "registro"; // El nombre de tu .html sin la extensión
    }

    /**
     * MODIFICACIÓN PARA FORMULARIOS:
     * Usamos @ModelAttribute en lugar de @RequestBody.
     * Esto permite que Spring capture los datos que el usuario escribe en los inputs del HTML.
     */

    /*
    se cambio de esto
    PostMapping("/insert")
    public UsuariosDTO insertarUsuario(@ModelAttribute UsuariosDTO dto) {
        // Al usar @ModelAttribute, Spring busca parámetros como 'username', 'password', etc.
        return service.insertarUsuario(dto);

        A esto de aca abajo
     */
    @PostMapping("/register")  //este procesa los datos del formulario
    public String insertarUsuario(@ModelAttribute UsuariosDTO dto) {
        // Al usar @ModelAttribute, Spring busca parámetros como 'username', 'password', etc.
        service.insertarUsuario(dto);
        // Una vez guardado, enviamos la instrucción de redirección.
        // Esto es lo que evita que veas el JSON en la pantalla blanca.
        return "redirect:/api/usuarios/registered";
    }

    // 4. Este muestra la página de éxito
    @GetMapping("/registered")
    public String paginaExito() {
        return "registered";
    }


    @GetMapping("/list")
    @ResponseBody // <-- Agregue esto para que devuelva el JSON y no busque un HTML
    public List <UsuariosDTO> listar(){
        return service.consulta();
    }



    @PutMapping("/{username}")      //se le pase el username es decir LA PK @PutMapping("/{id}")
    public UsuariosDTO actualizarUsuario(@PathVariable String username,  //el username se pasara atraves del path
                                         @RequestBody UsuariosDTO dto){  //las modificaciones se pasran por el Body de la request
        return service.actualizarUsuario(username, dto);                 //llama  service para usar el metodo y actualizar los datos, se le pasa el username y el dto.
    }
    @DeleteMapping("/{username}")
    public String borrarUsuario(@PathVariable String username){
        return service.eliminarUsuario(username);
    }
}
