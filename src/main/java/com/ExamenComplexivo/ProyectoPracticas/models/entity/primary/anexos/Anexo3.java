package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo3;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "anexo3")
public class Anexo3{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo3;

	@OneToOne
	@JoinColumn(name = "idPractica")
	private Practica practica;

	//Relacionado de uno a uno con documento anexo 1
	@OneToOne
	@JoinColumn(name = "id_documentoAnexo3", nullable = true)
	private Documento_Anexo3 documentoAnexo3;
}
