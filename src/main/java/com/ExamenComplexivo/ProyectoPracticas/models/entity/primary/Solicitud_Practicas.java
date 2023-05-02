package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "solicitud_practicas")
public class Solicitud_Practicas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSolicitudPracticas;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de envio de solicitud es obligatoria.")
    private Date fechaEnvioSolicitud;
    @NotNull(message = "El numero de estudiantes es obligatorio")
    private Integer numeroEstudiantes;
    private String nombreSolicitud;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de aceptacion de solicitud es obligatoria.")
    private Date fechaAceptacion;
    private boolean estadoSolicitud;
    private boolean estadoConvocatoria;
    private boolean estadoActividad;

    private String descripcionActividades;


    @OneToOne
    @JoinColumn(name = "id_documentoSolicitudPrc")
    private Documento_SolicitudPracticas documentoSolicitudPracticas;


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
