
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
            
            /* Se usa nextDouble(), el usuario escribe un número y presiona Enter
            Ese Enter queda en el buffer, lo limpio con scan.nextLine()
            Después el sistema pregunta "¿Deseas ingresar otro artículo? (s/n)" y  vuelvo a usar nextLine() para leer
            se queda leyendo un salto de línea vacío y nunca entra bien la respuesta
            para solucionarlo leo siempre con y convierto a double luego
            */
            System.out.println("Ingresa el precio del articulo"); 
            String precioStr = scan.nextLine();     //leo como texto el monto ingresado
            precio = Double.parseDouble(precioStr);     //convierto el texto del monto ingresado a Double, asi evito saltos y mi loop bunciona bien
            articulo.setPrecio(precio);
            
            System.out.println("Ingresa descripcion del articulo");
            descripcion = scan.nextLine();
            articulo.setDescripcion(descripcion);
            
            System.out.println(articulo); //muestra el articulo ingresado como un objeto
            System.out.println("Deseas ingresar otro articulo? (s/n)");
            String respuesta = scan.nextLine().trim();      //uso trim para eliminar espacios.
            
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
