package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
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
@Table(name = "documento_oficiopreseleccion")
public class Documento_OficioPreseleccion implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documentoOficioPreseleccion;

    @Column(name = "documento_oficiopreseleccion",columnDefinition = "bytea")
    private byte[] documento_oficiopreseleccion;

    //Relacionado con Solicitud Convocatoria de uno a uno
    @JsonIgnore
    @OneToOne(mappedBy = "documentooficio")
    private Solicitud_Convocatoria solicitudConvocatoria;

}
