package devreux.TechnoMarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proveedor")
public class Proveedor {
    private Integer id;
    private String nombre;
    private Integer telefono;
    private String email;
    private String direccion;
}
