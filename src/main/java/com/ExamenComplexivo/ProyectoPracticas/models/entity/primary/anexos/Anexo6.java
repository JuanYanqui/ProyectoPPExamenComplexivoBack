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

	private String dia;

	private Date hora_ingreso;

	private Date hora_salida;

	private Integer horas_diarias;

	private Integer total_horas;

	//Relacionado con practica de muchos a uno
	@ManyToOne
	@JoinColumn(name = "idPractica",referencedColumnName = "idPractica")
	private Practica practica;

	/*
	@OneToMany(mappedBy = "anexo6")
	private List<Documento_Anexo6> documentoAnexo6;
	*/

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "documento_anexo6_id", referencedColumnName = "id_documentoAnexo1")
	private Documento_Anexo6 documento_anexo6;

}
