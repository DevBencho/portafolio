package devreux.TechnoMarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movimiento_stock")
public class MovimientoStock {
    private Integer id;
    private TipoMovimiento tipoMovimiento;
    private Integer cantidad;
    private Date fecha;
}
