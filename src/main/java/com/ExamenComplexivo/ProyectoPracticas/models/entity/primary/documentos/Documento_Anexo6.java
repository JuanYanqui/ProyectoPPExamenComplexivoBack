package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo4;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo6;
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
@Table(name = "documento_Anexo6")
public class Documento_Anexo6 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_documentoAnexo1;

    @Column(name = "documento_anexo6",columnDefinition = "bytea")
    private byte[] documento_anexo6;

    @JsonIgnore
    @OneToOne(mappedBy = "documento_anexo6")
    private Anexo6 anexo6;
}
