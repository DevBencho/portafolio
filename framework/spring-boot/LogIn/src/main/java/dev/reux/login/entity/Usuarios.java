package dev.reux.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//esta clase representa la entidad dentro de la base de datos que vamos a crear mas adelante
@Entity
public class Usuarios {
    //asigna a la variable username como ID.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    private String password;
    private String email;
    private String name;
    private String lastname;
    private String age;
    private String gender;
}
