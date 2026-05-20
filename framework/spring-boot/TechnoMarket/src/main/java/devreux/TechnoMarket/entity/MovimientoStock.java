package devreux.TechnoMarket.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movimiento_stock")
public class MovimientoStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private TipoMovimiento tipoMovimiento;
    private Integer cantidad;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    /*Producto, Cliente y Proveedor tienen una relacion 1:N con MovimientoStock
    mi logica registra cada entrada o salida como un movimiento individual para cada tipo de producto,
    por eso la relación 1:N, un producto puede tener muchos movimientos, pero cada movimiento se relaciona
    con un solo producto, indiferente de las cantidades cada movimiento registraría la salida de varias unidades de un solo tipo de producto.
     */


}
