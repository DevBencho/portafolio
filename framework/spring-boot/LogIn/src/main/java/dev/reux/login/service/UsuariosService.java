package dev.reux.login.service;

import dev.reux.login.DTOs.UsuariosDTO;
import dev.reux.login.entity.Usuarios;
import dev.reux.login.mapper.UsuarioMapper;
import dev.reux.login.repository.Repos_Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UsuariosService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private Repos_Usuarios repository;

   //metodo para realizar una consulta a la bd de datos con buenas practicas sin comprometer los datos sensibles.
    public List<UsuariosDTO> consulta(){
        return repository.findAll()
                .stream()
                .map(UsuarioMapper::copyDTO)
                .collect(Collectors.toList());
    }

    //metodo paravedrtir el dto a entidad para guardar el usuario en la bd y
    @Transactional                     //CREA EL OBJETO DTO
    public UsuariosDTO insertarUsuario(UsuariosDTO dto){
                          //SE CONVIERTE A ENTIDAD
        Usuarios usuario = UsuarioMapper.copyEntity(dto);
                          //SE MANDA EL VALOR DEL INSERT A LA TABLA
                          // ES DECIR SER GUARDA EL USUARIO EN LA TABLA DE LA BD.
        Usuarios insert = entityManager.merge(usuario);
                          //USA MAPPER PARA CAMBIAR DE ENTIDAD A DTO Y MOSTRAR RESULTADO A CLIENTE
        return UsuarioMapper.copyDTO(insert);
    }

    //metodo para actualizar los usuarios de la BD
    public UsuariosDTO actualizarUsuario(String username, UsuariosDTO dto) {
        Optional<Usuarios> existe = repository.findById(username);
        if(existe.isPresent()){
            Usuarios user = existe.get();       //le pasamos el username almacenado en existe
            user.setPassword(dto.getPassword());
            user.setEmail(dto.getEmail());
            user.setName(dto.getName());
            user.setLastname(dto.getLastname());

            Usuarios actualizado = repository.save(user);

            return UsuarioMapper.copyDTO(actualizado);

        } else {

            throw new RuntimeException("Usuario con Username: " + dto.getUsername() + " No encontrado.");
        }

    }

}
