package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos;


import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
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
@Table(name = "documento_convocatoria")
public class Documento_Convocatoria implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documentoConvocatoria;

    @Column(name = "documento_convocatoria",columnDefinition = "bytea")
    //@Lob
    private byte[] documento_convocatoria;

    @JsonIgnore
    @OneToOne(mappedBy = "documentoConvocatoria")
    private Convocatorias convocatorias;


}
