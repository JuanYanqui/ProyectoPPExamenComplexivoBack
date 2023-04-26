package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class Aprobacion_Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsuario", insertable = false, updatable = false)
    private Long idAprobacionEstudiante;
    private Date fecha;
    private Boolean check_director;
    private Boolean check_responsable;
    private Boolean estado;

    @OneToOne
    @JoinColumn(name = "idSolicitudConvocatoria")
    private Solicitud_Convocatoria solicitudConvocatoria;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario_director;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario_responsable;

    @JsonIgnore
    @OneToOne(mappedBy = "aprobacionEstudiante")
    private Aprobacion_Empresa aprobacionEmpresa;
}
