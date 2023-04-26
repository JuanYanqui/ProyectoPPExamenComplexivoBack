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
@Table(name = "aprobacion_estudiante")

public class Aprobacion_Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAprobacionEstudiante;
    private Date fecha;
    private String estado;
}
