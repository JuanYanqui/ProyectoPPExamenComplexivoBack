package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.*;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_AsigTutorAcademico;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_AsigTutorEmpresarial;
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
@Table(name = "practica")
public class Practica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPractica;
    private String fechaInicio;
    private String fechaFin;
    private boolean estadoPractica;
    private String horaInicio;
    private String horaSalida;
    private boolean estadoHorario;
    private boolean checkAcademico;
    private boolean checkEmpresarial;
    private boolean estadoanexo1;
    private boolean estadoanexo2;
    private boolean estadoanexo3;
    private boolean estadoanexo4;
    private boolean estadoanexo5;
    private boolean estadoanexo6;
    private boolean estadoanexo7;
    private boolean estadoanexo8;


    //Relacion con Solicitud de convocatoria de uno a uno
    @OneToOne
    @JoinColumn(name = "idSolicitudConvocatoria", nullable = true)
    private Solicitud_Convocatoria solicitudConvocatoria;


    //Relacionado con tutor empresarials  de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idTutorEmpresarial",referencedColumnName = "idTutorEmpresarial", nullable = true)
    private Tutor_Empresarial tutorEmpresarial;

    //Relacionado con tutor academico  de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario",  nullable = true)
    private Usuario usuario;

    //Anexo1
    @JsonIgnore
    @OneToOne(mappedBy = "practica")
    private Anexo1 anexo1;

    //Anexo2
    @JsonIgnore
    @OneToOne(mappedBy = "practica")
    private Anexo2 anexo2;


    //Anexo3
    @JsonIgnore
    @OneToOne(mappedBy = "practica")
    private Anexo3 anexo3;


    //Anexo4
    @JsonIgnore
    @OneToOne(mappedBy = "practica")
    private Anexo4 anexo4;

    //Anexo5
    @JsonIgnore
    @OneToOne(mappedBy = "practica")
    private Anexo5 anexo5;

    @JsonIgnore
    @OneToMany(mappedBy = "practica",cascade = CascadeType.ALL)
    private List<Anexo6> anexo6;

    //Anexo7
    @JsonIgnore
    @OneToOne(mappedBy = "practica")
    private Anexo7 anexo7;

    //Anexo8
    @JsonIgnore
    @OneToOne(mappedBy = "practica")
    private Anexo8 anexo8;

    //Relacionado con documento de asignacion de tutor empresarial

    @OneToOne
    @JoinColumn(name = "id_documentoasigtutorempresarial", nullable = true)
    private Documento_AsigTutorEmpresarial documentoasignacion;

    @OneToOne
    @JoinColumn(name = "id_documentoasigtutoracademico", nullable = true)
    private Documento_AsigTutorAcademico documentoasignacionaca;


}
