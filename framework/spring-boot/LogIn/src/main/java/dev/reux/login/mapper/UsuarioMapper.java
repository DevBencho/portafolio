package dev.reux.login.mapper;

import dev.reux.login.DTOs.UsuariosDTO;
import dev.reux.login.entity.Usuarios;


//clase mapper quiero copiara la info de la bd a la dto

public class UsuarioMapper {
    //este metodo "copia" los datos de la bd utilizando los mentodos get de la clase DTO
    public static UsuariosDTO copyDTO (Usuarios usuario){
        return new UsuariosDTO(
                usuario.getUsername(),
                usuario.getAge(),
                usuario.getGender()
        );
    }
    //este metodo copia los datos del frontend y los pega en la bd usando los metodos set de la clase dto.
    public static Usuarios copyEntity (UsuariosDTO dto) {
        Usuarios usuario = new Usuarios();
        usuario.setUsername(dto.getUsername());
        usuario.setAge(dto.getAge());
        usuario.setGender(dto.getGender());
        return usuario;
    }

}
