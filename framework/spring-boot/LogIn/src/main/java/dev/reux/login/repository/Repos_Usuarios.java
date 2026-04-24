package dev.reux.login.repository;

import dev.reux.login.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

//creo la interfaz que extiende jparepository que es una capa de acceso a los datos en la
//cruedrepository, pagingandsortingrepository
public interface Repos_Usuarios extends JpaRepository<Usuarios, String> {
}
