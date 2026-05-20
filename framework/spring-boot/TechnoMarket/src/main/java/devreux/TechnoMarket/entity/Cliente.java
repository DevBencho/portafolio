package devreux.TechnoMarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List; //importe la clase List para poder usar listas.

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rut;
    private String nombre;
    private Integer telefono;
    private String email;
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<ClienteProducto> listaCompra; //aca defini una lista de objetos ClienteProducto con la cual podre obtener un listado de los producto/s comprandos por el cliente

    @OneToMany(mappedBy = "cliente") //indica que la relacion esta definida en la clase MovimientoStocko en el campo cliente
    private List<MovimientoStock> movimientoStock;

}
