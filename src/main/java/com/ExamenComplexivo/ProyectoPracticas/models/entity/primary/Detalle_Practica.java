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
@Table(name = "detalle_practica")
public class Detalle_Practica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDetallePractica;
    private String horario;
}
