package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "listconvocatoriaest")
@NoArgsConstructor
@AllArgsConstructor
public class listConvocatorias {

	@Id
	private Long idconvocatoria;
	private int ciclo;
	@Column(name = "fechaenvio")
	@Temporal(TemporalType.DATE)
	private Date fechaenvio;
	@Column(name = "fecharecepcion")
	@Temporal(TemporalType.DATE)
	private Date fecharecepcion;
	private int idpracticas;
	private int idrepresentante;
	private String materias;
	private String responsable;
	private String empresa;
	private String actividades;

}
