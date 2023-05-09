package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo5;
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
@Table(name = "documento_Anexo5")
public class Documento_Anexo5 {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documentoAnexo5;

    @Column(name = "documento_anexo5",columnDefinition = "bytea")
    private byte[] documento_anexo5;

    //Relacion con anexo5 de uno a uno
    @JsonIgnore
    @OneToOne(mappedBy = "documentoAnexo5")
    private Anexo5 anexo5;

}
