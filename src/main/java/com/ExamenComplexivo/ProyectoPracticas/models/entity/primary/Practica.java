package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPractica;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de inicio es obligatoria.")
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de fin es obligatoria.")
    private Date fechaFin;
    private boolean estadoPractica;
    private String horario;

    //Relacion con Solicitud de convocatoria de uno a uno
    @OneToOne
    @JoinColumn(name = "idSolicitudConvocatoria")
    private Solicitud_Convocatoria solicitudConvocatoria;


    //Relacionado con tutor empresarials  de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idTutorEmpresarial",referencedColumnName = "idTutorEmpresarial")
    private Tutor_Empresarial tutorEmpresarial;

    //Relacionado con tutor academico  de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario")
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

}
