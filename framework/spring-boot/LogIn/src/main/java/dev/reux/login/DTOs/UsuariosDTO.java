package dev.reux.login.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

//creo la clase que que mostrara la informacion consultada para no exponer la entidad de la bd
public class UsuariosDTO {
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String lastname;
    private int age;
    private String gender;
    //constructores para inicializar la clase

    public UsuariosDTO() {

    }

    public UsuariosDTO(String username, String password, String email, String name, String lastname, int age, String gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
    }

    //y todos sus respectivos getters y setters para hacerder a los atributos


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Usuario: " + username + "\n" +
                "Contraseña: [PROTEGIDO]\n" + // Por seguridad, es mejor no imprimir la clave real
                "Email: " + email + "\n" +
                "Nombre: " + name + "\n" +
                "Apellido: " + lastname + "\n" +
                "Edad: " + age + "\n" +
                "Género: " + gender;
    }

    //ahora debo modificar mi  controlador para que trabaje con la dto ya que el metodo del controlador
    //esta interactuando directamente con la BD
    //para esto debo crear la clase mapper, la cual es la que copia la informacion "no sensible"
    // de la entity y la pega en la DTO
}
