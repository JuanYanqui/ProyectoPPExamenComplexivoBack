package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "materias")
public class Materias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMaterias;
    private String nombre_materia;

    @JsonIgnore
    @OneToOne(mappedBy = "materias")
    private Detalle_Actividades detalleActividades;
}
