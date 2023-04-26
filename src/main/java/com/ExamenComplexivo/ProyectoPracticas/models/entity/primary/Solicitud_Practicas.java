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
@Table(name = "solicitud_practicas")
public class Solicitud_Practicas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSolicitudPracticas;
    private Date fecha_solicitud;
    private Integer numero_estudiantes;

    private byte documento_solicitud_practicas;

    @ManyToOne
    @JoinColumn(name = "idTutorEmpresarial",referencedColumnName = "idTutorEmpresarial")
    private Tutor_Empresarial tutorEmpresarial;

    @ManyToOne
    @JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario")
    private Usuario usuario_responsable_pp;

    @JsonIgnore
    @OneToMany(mappedBy = "solicitudPracticas",cascade = CascadeType.ALL)
    private List<Actividades> actividades;

    @JsonIgnore
    @OneToOne(mappedBy = "solicitudPracticas")
    private Convocatorias convocatorias;
}
