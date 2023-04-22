package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "A1PlanFormacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class A1_PlanFormacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_A1PlanFormacion;
	private String ResultadosEsp;
	private String DescActividad;
	private String periodoEq;
	private String AsignaturaRel;
	private long Horas;

}
