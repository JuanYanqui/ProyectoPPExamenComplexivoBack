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
    private Date fechaEnvioSolicitud;
    private Integer numeroEstudiantes;
    private String nombreSolicitud;
    private boolean estadoSolicitud;
    private Date fechaAceptacion;
    private boolean estadoActividad;
    private byte documento_solicitud_practicas;


    //Relacionado con tutor empresarial de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idTutorEmpresarial",referencedColumnName = "idTutorEmpresarial")
    private Tutor_Empresarial tutorEmpresarial;

    //Relacionado con responsable de practicas de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idResponsablePPP",referencedColumnName = "idResponsablePPP")
    private Responsable_PPP responsablePPP;


    //Relacionado con convocatoria de uno a uno
    @JsonIgnore
    @OneToOne(mappedBy = "solicitudPracticas")
    private Convocatorias convocatorias;


    //Relacionado con requerimientos de uno a muchos
    @JsonIgnore
    @OneToMany(mappedBy = "solicitudPracticas",cascade = CascadeType.ALL)
    private List<Requerimientos> requerimientos;
}
