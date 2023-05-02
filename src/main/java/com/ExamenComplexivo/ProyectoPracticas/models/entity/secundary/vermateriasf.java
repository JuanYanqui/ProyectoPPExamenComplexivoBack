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
@Table(name = "vistaMaterias")
public class vermateriasf {
    @Id
    private Integer id_materia;
    private String materia_codigo;
    private String materia_nombre;
    private String materia_objetivo;
    private Integer id_carrera;

}
