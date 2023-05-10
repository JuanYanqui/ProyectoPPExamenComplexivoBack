package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
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
@Table(name = "documento_convenio")
public class Documento_Convenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documentoCnv;

    @Column(name = "documento_convenio",columnDefinition = "bytea")
    private byte[] documentoConvenio;

    //Relacionado con convenio de uno a uno
    @JsonIgnore
    @OneToOne(mappedBy = "documentoConvenio")
    private Convenio convenio;
}
