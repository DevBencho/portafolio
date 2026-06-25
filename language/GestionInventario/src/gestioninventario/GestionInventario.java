
package gestioninventario;
import java.util.Scanner;
import java.util.InputMismatchException;
import operacionesCRUD.CrearArticulo; //importo el paquete y la clase para poder usarlas en metodo main

public class GestionInventario {
    static Scanner scan = new Scanner(System.in);
    static int opcion;
    
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema integral de gestion de inventario");
        System.out.println("1.  Buscar articulo");
        System.out.println("2.  Ingresar articulo");
        System.out.println("3.  Modificar articulo");
        System.out.println("4.  Eliminar articulo");
        System.out.println("5.  Salir de Menu Principal");
        int opcion =0; //inicializo la variable opcion para poder usarla en el while de mi loop
        System.out.println("Slecciona el numero de la opcion a realizar");
        do { //bloque do para que el sistema permita ejecutar y solicitar la opcion del menu hasta cumplir condicion
            try {
            opcion = scan.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("1. Buscar articulo");
                    break;
                case 2:
                    System.out.println("2. ingresar articulo");
                    CrearArticulo maker = new CrearArticulo(); //creo una instancia de la clase CrearArticulo para poder acceder a su metodo principal.
                    Articulo nuevoArticulo = new Articulo(); //creo un articulo vacio llamando al constructor de Articulo.
                    maker.ingresarArticulo(nuevoArticulo); // utilizo maker (la clase para crear un articulo Crud) para acceder al metodo ingresarArticulo
                                                           //y le paso el objeto vacio creado de Articulo (nuevoArticulo) como parametro para el metodo ingresarArticulo. 
                    break;
                case 3:
                    System.out.println("3. Modificar articulo");
                    break;
                case 4:
                    System.out.println("4. Eliminar articulo");
                    break;
                case 5:
                    System.out.println("5. Hasta Pronto!");
                    break;
                default:
                    System.out.println("Por favor ingresa un numero de opcion valido");
            }        
        } catch (InputMismatchException e) {
            System.out.println("Ingresa una opocion valida");
            scan.next(); //limpa buffer
        } 
      } while (opcion!= 5); //condicion que permite ejecutar el bucle o salir de el.   
    }   
}
