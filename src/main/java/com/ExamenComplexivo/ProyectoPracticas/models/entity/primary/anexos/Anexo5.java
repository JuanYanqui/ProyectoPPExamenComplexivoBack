package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo5;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "anexo5")
public class Anexo5 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo5;
	private boolean estado_academico;
	private boolean estado_empresarial;


	@OneToOne
	@JoinColumn(name = "idPractica")
	private Practica practica;

	//Relacionado de uno a uno con documento anexo 5
	@OneToOne
	@JoinColumn(name = "id_documentoAnexo5", nullable = true)
	private Documento_Anexo5 documentoAnexo5;

}
