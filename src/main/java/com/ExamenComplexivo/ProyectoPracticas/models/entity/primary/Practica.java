package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "practica")
public class Practica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPractica;
    private Date fecha_inicio;
    private Date fecha_fin;
}
