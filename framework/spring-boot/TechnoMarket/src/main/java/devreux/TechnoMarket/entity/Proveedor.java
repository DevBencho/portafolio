package devreux.TechnoMarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List; //importe la clase List para poder usar listas.

import java.awt.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer telefono;
    private String email;
    private String direccion;

    @OneToMany(mappedBy = "proveedor") //indica que la relacion esta definida en la clase Producto en el campo proveedor
    private List<Producto> listaProducto; //coloco una lista, porque mi logica indica que un unico proveedor me surte muchos productos, por ende me interesa saber todos los productos que me surte un unico proveedor

    @OneToMany(mappedBy = "proveedor")//indica que la relacion esta definida en la clase MovimientoStock en el campo proveedor
    private List<MovimientoStock> movimientoStock;
}
