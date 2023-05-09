package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos;


import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "documento_solicitud_practicas")

public class Documento_SolicitudPracticas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documentoSolicitudPrc;

    @Column(name = "documento_solicitud_practicas",columnDefinition = "bytea")
    //@Lob
    private byte[] documento_solicitud_practicas;

    @JsonIgnore
    @OneToOne(mappedBy = "documentoSolicitudPracticas")
    private Solicitud_Practicas solicitudPracticas;

}
