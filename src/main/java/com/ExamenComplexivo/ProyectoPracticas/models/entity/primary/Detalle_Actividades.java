package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

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
@Table(name = "detalle_actividades")
public class Detalle_Actividades {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDetalleActividaes;
    private String lenguaje_programacion;
    private String frameworks;
    private String metodologias;
    private String sgvd;

    @OneToOne
    @JoinColumn(name = "idMaterias")
    private Materias materias;


    @OneToOne
    @JoinColumn(name = "idActividades")
    private Actividades actividades;
}
