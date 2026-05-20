package devreux.TechnoMarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Double precio;
    private String marca;
    private String fabricado;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "proveedor_id") //indica que esta clase es la owner de la relacion con Proveedor y asigna el nombre de la FK como proveedor_id
    private Proveedor proveedor; //defino un objeto de mi clase Proveedor, llamado proveedor quien es el que maneja la FK.

    @OneToMany(mappedBy = "producto")
    private List<ClienteProducto> listaCompra;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria; //defino un objeto de mi clase Categoria, llamado categoria quien es el que maneja la FK.

    @OneToMany(mappedBy = "producto")
    private List<MovimientoStock> movimientoStock;
}
