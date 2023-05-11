package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
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
@Table(name = "documento_asigtutoracademico")
public class Documento_AsigTutorAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_documentoasigtutoracademico;

    @Column(name = "documento_asigtutoracademico",columnDefinition = "bytea")
    private byte[] documento_asigtutoracademico;

    //Relacionado con Practica de uno a uno
    @JsonIgnore
    @OneToOne(mappedBy = "documentoasignacionaca")
    private Practica practica;
}
