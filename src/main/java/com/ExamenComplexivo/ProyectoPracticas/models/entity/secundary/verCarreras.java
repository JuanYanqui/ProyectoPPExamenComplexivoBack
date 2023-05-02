package com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vistaCarreras")
public class verCarreras {

    @Id
    private Integer id_carrera;

    private String carrera_nombre;

    private String carrera_modalidad;

    private String tipo_carrera;

}
