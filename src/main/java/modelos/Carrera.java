package modelos;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private  Long id;

    @Column (name = "nombre_carrera", length = 120, nullable = false)
    private String nombre;

    @Column (name = "precio_carrera")
    @DecimalMin(value = " 0.01", message =  "debe ser mayor a 0 ")
    private  double precio;
}
