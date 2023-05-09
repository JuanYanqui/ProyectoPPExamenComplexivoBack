package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo7;
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
@Table(name = "documento_Anexo7")
public class Documento_Anexo7 {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documentoAnexo7;

    @Column(name = "documento_anexo7",columnDefinition = "bytea")
    private byte[] documento_anexo7;

    //Relacion con anexo 7
    @JsonIgnore
    @OneToOne(mappedBy = "documentoAnexo7" )
    private Anexo7 anexo7;
}
