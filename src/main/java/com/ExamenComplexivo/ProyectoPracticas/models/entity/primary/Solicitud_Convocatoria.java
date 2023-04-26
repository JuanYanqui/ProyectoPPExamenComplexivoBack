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
@Table(name = "solicitud_convocatoria")
public class Solicitud_Convocatoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSolicitudConvocatoria;
    private Date fecha;
    private String estado;
}
