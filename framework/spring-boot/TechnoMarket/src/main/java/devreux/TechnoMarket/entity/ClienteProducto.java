package devreux.TechnoMarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente_producto")
public class ClienteProducto { //Cliente y Producto segun mi logica de negocio tienen un relacion N:M por ende cree esta tabla intermedia
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cantidad; //representa la cantidad comprada por el cliente
    private LocalDate fechaCompra; //fecha en la que realizo su compra
    private Double precio; //precio que pago por el producto, a menera de *registro historico*

    /* Basicamente cree esta tabla intermedia por 2 motivos:
    1:La relacion entre Cliente y Producto segun mi logica de negocio es de N:M
    2:Pretendia hacer cierto tipos de operaciones que me obligan tener atributos adicionales a solo las llaves foraneas
    por ese motivo no use simplemente la anotacion @JoinTable en alguna de mis entidades Cliente o Producto
    * */

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

}
