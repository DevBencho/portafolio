package dev.reux.login.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Usuarios")
public class Usuarios implements Persistable<String> {

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

    // Transient le dice a JPA que no cree esta columna en la base de datos
    @Transient
    private boolean isUpdate = false;

    @Override
    public String getId() {
        return this.username;
    }

    /*
     *me estaba dando un error en la al eliminar un usuario, la consola dabe ok, postman daba ok pero el registro aun estaba en la bd
     * Si isUpdate es falso, es un INSERT. Si es verdadero, es un UPDATE/DELETE.
     */
    @Override
    public boolean isNew() {
        return !isUpdate;

        /*
         *me estaba dando un error al eliminar un usuario, la consola daba ok, postman daba ok, pero el registro aun estaba en la bd.
         *Spring Data JPA decide si debe hacer un INSERT o un UPDATE revisando si el ID es nulo, el id en este caso username es un String que se escribe en la request, por eso nunca es nulo
         * por eso para hibernate Si es nuevo, no puede estar en la base de datos, así que no lo borraba. Por eso terminaba el proceso con éxito (200 OK) pero sin tocar la base de datos.
         * Si isUpdate es falso, es un INSERT. Si es verdadero, es un UPDATE/DELETE.
         */
    }

    // Metodo para marcar que el objeto ya existe en la BD
    public void markNotNew() {
        this.isUpdate = true;
    }
}