package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo6;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "anexo6")
public class Anexo6 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo6;
	private Integer numero_semana;
	private String fecha_inicio;
	private String fecha_fin;
	private boolean estado_estudiante;
	private boolean estado_academico;
	private boolean estado_especifico;

	//Relacionado con practica de muchos a uno
	@ManyToOne
	@JoinColumn(name = "idPractica",referencedColumnName = "idPractica")
	private Practica practica;

	@ManyToOne
	@JoinColumn(name = "id_documentoAnexo6",referencedColumnName = "id_documentoAnexo6", nullable = true)
	private Documento_Anexo6 documento_anexo6;
}
