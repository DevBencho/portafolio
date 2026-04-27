package dev.reux.login.DTOs;
//creo la clase que que mostrara la informacion consultada para no exponer la entidad de la bd
public class UsuariosDTO {
    private String username;
    private int age;
    private String gender;
    //constructores para inicializar la clase
    public UsuariosDTO(String username, int age, String gender) {
        this.age = age;
        this.gender = gender;
        this.username = username;
    }
    //y todos sus respectivos getters y setters para hacerder a los atributos
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Usuario: " + username + "\n" +
                "Edad: " + age + "\n" +
                "Genero: " + gender;
    }
    //ahora debo modificar mi  controlador para que trabaje con la dto ya que el metodo del controlador
    //esta interactuando directamente con la BD
    //para esto debo crear la clase mapper, la cual es la que copia la informacion "no sensible"
    // de la entity y la pega en la DTO
}
