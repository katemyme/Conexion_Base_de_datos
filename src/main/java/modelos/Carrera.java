package modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;

@Entity
@Table(name = "carreras")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Carrera {
    @Id
    @Column(name = "id_carrera")
    private  Long id;

    @Column (name = "nombre_carrera", length = 120, nullable = false)
    private String nombre;

    @Column (name = "precio_carrera")
    @DecimalMin(value = " 0.01", message =  "debe ser mayor a 0 ")
    private  double precio;
}
