package devreux.TechnoMarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "producto")
public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;
    private String marca;
    private String fabricado;
    private Integer sotck;

}
