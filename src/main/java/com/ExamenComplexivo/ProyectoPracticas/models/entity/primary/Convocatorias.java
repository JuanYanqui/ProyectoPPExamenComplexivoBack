package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
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

    private String fechaPublicacion;

    private String fechaExpiracion;
    private boolean estadoConvocatoria;

    @OneToOne
    @JoinColumn(name = "id_documentoConvocatoria", nullable = true)
    private Documento_Convocatoria documentoConvocatoria;

    //Relacionado con solicitud practicas de uno a uno
    @OneToOne
    @JoinColumn(name = "idSolicitudPracticas")
    private Solicitud_Practicas solicitudPracticas;

    //Relacionado con solicitud convocatoria de uno a uno
    @JsonIgnore
    @OneToMany(mappedBy = "convocatoria",cascade = CascadeType.ALL)
    private List<Solicitud_Convocatoria> solicitudConvocatorias;
}
