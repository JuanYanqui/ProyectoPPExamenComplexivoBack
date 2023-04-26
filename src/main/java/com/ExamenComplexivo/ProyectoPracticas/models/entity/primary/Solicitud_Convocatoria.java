package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idEstudiantePracticas")
    private List<Estudiante_Practicante> estudiantePracticantes;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idConvocatorias")
    private List<Convocatorias> convocatorias;

    @JsonIgnore
    @OneToOne(mappedBy = "solicitudConvocatoria")
    private Aprobacion_Estudiante aprobacionEstudiante;


}
