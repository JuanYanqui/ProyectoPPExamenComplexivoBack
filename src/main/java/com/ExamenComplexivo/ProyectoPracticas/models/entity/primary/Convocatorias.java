package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.ContentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConvocatorias;
    //@Pattern(regexp = "^(CONVOCATORIA – TSDS -PPP-)(\\d{4})-(\\d{3})$", message = "El formato del nombre de la convocatoria no es válido.")
    private String nombreConvocatoria;

    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "La fecha de expiración es obligatoria.")
    private Date fechaExpiracion;
    private boolean estadoConvocatoria;

    @Column(name = "documento_convocatoria", columnDefinition = "bytea")
    private byte[] documento_convocatoria;

    //Relacionado con solicitud practicas de uno a uno
    @OneToOne
    @JoinColumn(name = "idSolicitudPracticas")
    private Solicitud_Practicas solicitudPracticas;

    //Relacionado con solicitud convocatoria de uno a uno
    @JsonIgnore
    @OneToOne(mappedBy = "convocatoria")
    private Solicitud_Convocatoria solicitudConvocatoria ;
}
