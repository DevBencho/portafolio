package dev.reux.login.controller;

import dev.reux.login.DTOs.UsuariosDTO;
import dev.reux.login.entity.Usuarios;
import dev.reux.login.mapper.UsuarioMapper;
import dev.reux.login.repository.Repos_Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class Controlador {



    //avanzando el codigo mopvidficamos a que el controlador usara a la DTO para acceder a los datos  y no directamente a la BD.
    //@GetMapping("/usuarios")
    //la vista devolvera una lista de tipo Usuarios que retorna un lista de todos los usuarios del repositorio
    //public List<Usuarios> consulta(){
    //    return (List<Usuarios>) repository.findAll();
    //}

    //inyeccion de dependencias para invocacion de los metodos del repositorio
    @Autowired
    private Repos_Usuarios repository;

    @GetMapping("/usuarios")
    public List <UsuariosDTO> consulta(){
        return repository.findAll()
                    .stream()
                    .map(UsuarioMapper::copyDTO)

                    .collect(Collectors.toList());
    }

}
