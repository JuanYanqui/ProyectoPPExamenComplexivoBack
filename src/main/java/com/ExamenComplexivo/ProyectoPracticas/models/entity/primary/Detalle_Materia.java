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
@Table(name = "detalle_materia")
public class Detalle_Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDetalleMateria;
    private String resultados_esperados;
    private String objetivos;

    @OneToOne
    @JoinColumn(name = "idMaterias")
    private Materias materias;

    @ManyToOne
    @JoinColumn(name = "idConvocatorias",referencedColumnName = "idConvocatorias")
    private Convocatorias convocatorias;
}
