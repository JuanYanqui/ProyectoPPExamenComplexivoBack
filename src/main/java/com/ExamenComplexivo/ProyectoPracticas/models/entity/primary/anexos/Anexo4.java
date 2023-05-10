package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo4;
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
@Table(name = "anexo4")
public class Anexo4 {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo4;
	private String fecha_actual;

	@OneToOne
	@JoinColumn(name = "idPractica")
	private Practica practica;

	//Relacionado de uno a uno con documento anexo4
	@OneToOne
	@JoinColumn(name = "id_documentoAnexo4", nullable = true)
	private Documento_Anexo4 documentoAnexo4;
}
