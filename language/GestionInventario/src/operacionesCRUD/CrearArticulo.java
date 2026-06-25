
package operacionesCRUD;
import gestioninventario.Articulo;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CrearArticulo {
    
    String nombre;
    String codigo;
    double precio;
    String descripcion;
    
    Scanner scan = new Scanner(System.in);
    
    public void ingresarArticulo(Articulo articulo){
        boolean control = true;
        do {
            try {
            System.out.println("Ingresa nombre articulo");
            nombre = scan.nextLine();
            articulo.setNombre(nombre);
            
            System.out.println("Ingresa el codigo de producto");
            codigo = scan.nextLine();
            articulo.setCodigo(codigo);
            
            System.out.println("Ingresa el precio del articulo");
            precio = scan.nextDouble();
            articulo.setPrecio(precio);
            scan.nextLine(); //limpia el salto de linea (de double a String)
            
            System.out.println("Ingresa descripcion del articulo");
            descripcion = scan.nextLine();
            articulo.setDescripcion(descripcion);
            
            System.out.println(articulo); //muestra el articulo ingresado como un objeto
            System.out.println("Deseas ingresar otro articulo? (s/n)");
            String respuesta = scan.nextLine();
                if (respuesta.equalsIgnoreCase("n")) {
                    control = false;
                }
            
            } catch (InputMismatchException e) {
                System.out.println("Dato invalidao, revisa y llena todos los datos solicitados para ingresar articulo al inventario");
                scan.next(); //limpia buffer
            }
        } while (control);
            
        }
}
