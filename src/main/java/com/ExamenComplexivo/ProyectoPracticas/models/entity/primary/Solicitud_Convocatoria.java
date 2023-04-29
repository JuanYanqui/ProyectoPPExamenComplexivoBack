package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;
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
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "solicitud_convocatoria")
public class Solicitud_Convocatoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSolicitudConvocatoria;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de envio es obligatoria.")
    private Date fechaEnvio;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de aprobacion es obligatoria.")
    private Date fechaAprobacion;
    private boolean checkDirector;
    private boolean checkResponsable;
    private boolean checkEmpresarial;
    private boolean estadoSolicitudConvo;
/*
    @Column(name = "documentoSC", columnDefinition = "bytea")
    private byte[] documentoSC;
*/
    //Relacionado con estudiante practicass de uno a muchos
    @ManyToOne
    @JoinColumn(name = "idEstudiantePracticas",referencedColumnName = "idEstudiantePracticas")
    private Estudiante_Practicante estudiantePracticante;

    //Relacion con usuario de uno a uno
    @OneToOne
    @JoinColumn(name = "idConvocatorias")
    private Convocatorias convocatoria;

    //Relacionado con tutor_empresarial de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idTutorEmpresarial",referencedColumnName = "idTutorEmpresarial")
    private Tutor_Empresarial tutorEmpresarial;

    //Relacionado con responsable practicas de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idResponsablePPP",referencedColumnName = "idResponsablePPP")
    private Responsable_PPP responsablePPP;

    //Relacionado con usuario de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario")
    private Usuario usuario;

    //Relacionado con practica de uno a uno
    @JsonIgnore
    @OneToOne(mappedBy = "solicitudConvocatoria")
    private Practica practica;
}
