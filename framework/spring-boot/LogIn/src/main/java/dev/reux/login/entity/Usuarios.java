package dev.reux.login.entity;

import jakarta.persistence.*;
import lombok.Data;

//2.esta clase representa la entidad dentro de la base de datos que vamos a crear mas adelante
@Entity
@Data
@Table(name = "Usuarios")
public class Usuarios {
    //asigna a la variable username como ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    private String password;
    private String email;
    private String name;
    private String lastname;
    private int age;
    private String gender;
}
