package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "convocatorias")
public class Convocatorias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idConvocatorias;
    private String nombreConvocatoria;
    private Date fechaPublicacion;
    private Date fechaExpiracion;
    private boolean estadoConvocatoria;
    private byte documento_convocatoria;

    //Relacionado con solicitud practicas de uno a uno
    @OneToOne
    @JoinColumn(name = "idSolicitudPracticas")
    private Solicitud_Practicas solicitudPracticas;

    //Relacionado con solicitud convocatoria de uno a uno
    @JsonIgnore
    @OneToOne(mappedBy = "convocatoria")
    private Solicitud_Convocatoria solicitudConvocatoria ;
}
