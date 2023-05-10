package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
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
@Table(name = "documento_asigtutorempresarial")
public class Documento_AsigTutorEmpresarial implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documentoasigtutorempresarial;

    @Column(name = "documento_asigtutorempresarial",columnDefinition = "bytea")
    private byte[] documento_asigtutorempresarial;

    //Relacionado con Practica de uno a uno
    @JsonIgnore
    @OneToOne(mappedBy = "documentoasignacion")
    private Practica practica;

}
