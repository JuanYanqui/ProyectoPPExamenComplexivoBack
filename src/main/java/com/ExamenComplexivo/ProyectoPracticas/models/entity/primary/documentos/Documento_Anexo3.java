package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo3;
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
@Table(name = "documento_Anexo3")
public class Documento_Anexo3 implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documentoAnexo3;

    @Column(name = "documento_anexo3",columnDefinition = "bytea")
    private byte[] documento_anexo3;

    //Relacionado con anexo1 de uno a uno
    @JsonIgnore
    @OneToOne(mappedBy = "documentoAnexo3")
    private Anexo3 anexo3;
}
