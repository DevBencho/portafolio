package dev.reux.login.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

//2.esta clase representa la entidad dentro de la base de datos que vamos a crear mas adelante
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Usuarios")
public class Usuarios implements Persistable<String> {
    //asigna a la variable username como ID.
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private String gender;

    //Devuelve el ID de la entidad para que Spring Data lo reconozca.
    @Override
    public String getId() {
        return this.username;
    }


    /*
     * Al retornar siempre true, le indicamos a Hibernate que no intente
     * buscar el registro antes de insertarlo (SELECT), sino que ejecute
     * directamente el INSERT. Esto soluciona los errores de "Optimistic Locking"
     * y "Detached Entity" cuando usamos IDs manuales.
     */
    @Override
    public boolean isNew() {

        return true;
    }

}
