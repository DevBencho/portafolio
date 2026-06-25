
package gestioninventario;


public class Articulo {
    private String nombre;
    private String codigo;
    private double precio;
    private String descripcion;

    public Articulo(String nombre, String codigo, double precio, String descripcion) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Articulo() {
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Codigo: " + codigo + "\n" +
               "Precio: " + precio + "\n" +
               "Descripcion: " + descripcion;
    }
}

