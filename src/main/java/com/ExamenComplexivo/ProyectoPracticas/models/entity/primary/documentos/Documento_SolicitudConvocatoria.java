package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "documento_solicitud_convocatoria")
public class Documento_SolicitudConvocatoria {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documentoSolicitudConvocatoria;

    @Column(name = "documento_solicitud_convocatoria",columnDefinition = "bytea", nullable = true)
    //@Lob
    private byte[] documento_solicitud_convocatoria;

    @JsonIgnore
    @OneToOne(mappedBy = "documentoSolicitudConvocatoria")
    private Solicitud_Convocatoria solicitudConvocatoria;


}
