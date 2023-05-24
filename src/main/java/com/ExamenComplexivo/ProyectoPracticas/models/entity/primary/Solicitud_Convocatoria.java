package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_OficioPreseleccion;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudConvocatoria;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitudConvocatoria;
    private String fechaEnvio;
    private String fechaAprobacion;
    private String fechaSeleccion;
    private String ciclo;
    private String periodo;
    private String numero_contacto;
    private boolean checkDirector;
    private boolean checkResponsable;
    private boolean checkEmpresarial;
    private boolean checkPractica;
    private boolean estadoSolicitudConvo;

    private boolean estadoestudiante;


    @OneToOne
    @JoinColumn(name = "id_documento_solicitud", nullable = true)
    private Documento_SolicitudConvocatoria documentoSolicitudConvocatoria;

    //Relacionado con estudiante practicass de uno a muchos
    @ManyToOne
    @JoinColumn(name = "idEstudiantePracticas",referencedColumnName = "idEstudiantePracticas", nullable = true)
    private Estudiante_Practicante estudiantePracticante;

    //Relacion con usuario de uno a uno

//////
    @ManyToOne
    @JoinColumn(name = "idConvocatorias",referencedColumnName = "idConvocatorias", nullable = true)
    private Convocatorias convocatoria;

    //Relacionado con tutor_empresarial de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idTutorEmpresarial",referencedColumnName = "idTutorEmpresarial", nullable = true)
    private Tutor_Empresarial tutorEmpresarial;

    //Relacionado con responsable practicas de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idResponsablePPP",referencedColumnName = "idResponsablePPP", nullable = true)
    private Responsable_PPP responsablePPP;

    //Relacionado con usuario de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario", nullable = true)
    private Usuario usuario;

    //Relacionado con practica de uno a uno
    @JsonIgnore
    @OneToOne(mappedBy = "solicitudConvocatoria")
    private Practica practica;

    //Relacionado on documento oficio uno a uno
    @OneToOne
    @JoinColumn(name = "id_documentoOficioPreseleccion", nullable = true)
    private Documento_OficioPreseleccion documentooficio;
}
