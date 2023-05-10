package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convenio;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "anexo1")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Anexo1 {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo1;
	private String itv;
	private String fecha_inicio;
	private String fecha_final;
	private String objetivos;
	private String actividades;
	private String areas;
	private Integer horas;

	//Relacionado con practica de uno a uno
	@OneToOne
	@JoinColumn(name = "idPractica")
	private Practica practica;

	//Relacionado de uno a uno con documento anexo 1
	@OneToOne
	@JoinColumn(name = "id_documentoAnexo1", nullable = true)
	private Documento_Anexo1 documentoAnexo1;

}
