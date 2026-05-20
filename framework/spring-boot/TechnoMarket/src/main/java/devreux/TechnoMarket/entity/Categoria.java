package devreux.TechnoMarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "categoria")//indica que la relacion esta definida en la clase Producto en el campo categoria
    private List<Producto> listaProductoPorCategoria; //aca defini una lista de objetos Producto con la cual podre obtener un listado de todos los productos por categoria
}
