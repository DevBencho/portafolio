package dev.reux.login.service;

import dev.reux.login.DTOs.UsuariosDTO;
import dev.reux.login.entity.Usuarios;
import dev.reux.login.mapper.UsuarioMapper;
import dev.reux.login.repository.Repos_Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuariosService {

    @Autowired
    private Repos_Usuarios repository;

    public List<UsuariosDTO> consulta(){
        return repository.findAll()
                .stream()
                .map(UsuarioMapper::copyDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public UsuariosDTO insertarUsuario(UsuariosDTO dto){
        Usuarios usuario = UsuarioMapper.copyEntity(dto);
        // Como es nuevo por defecto (isUpdate = false), save() hará un INSERT
        Usuarios insert = repository.save(usuario);
        return UsuarioMapper.copyDTO(insert);
    }

    @Transactional
    public UsuariosDTO actualizarUsuario(String username, UsuariosDTO dto) {
        return repository.findById(username).map(user -> {
            // MODIFICACIÓN: Marcamos que NO es nuevo para que JPA permita el UPDATE
            user.markNotNew();

            user.setPassword(dto.getPassword());
            user.setEmail(dto.getEmail());
            user.setName(dto.getName());
            user.setLastname(dto.getLastname());
            user.setAge(dto.getAge());
            user.setGender(dto.getGender());

            Usuarios actualizado = repository.saveAndFlush(user);
            return UsuarioMapper.copyDTO(actualizado);
        }).orElseThrow(() -> new RuntimeException("Usuario con Username: " + username + " no encontrado."));
    }

    @Transactional
    public String eliminarUsuario(String username) {
        Optional<Usuarios> usuarioOpcional = repository.findById(username);

        if (usuarioOpcional.isPresent()) {
            Usuarios user = usuarioOpcional.get();
            // MODIFICACIÓN: Marcamos que NO es nuevo para que JPA permita el DELETE
            user.markNotNew();

            repository.delete(user);
            repository.flush();

            System.out.println("DEBUG: Borrado confirmado para: " + username);
            return "Usuario '" + username + "' eliminado correctamente";
        } else {
            System.out.println("DEBUG: No se encontró el usuario en la BD: " + username);
            return "Error: El usuario '" + username + "' no existe.";
        }
    }
}