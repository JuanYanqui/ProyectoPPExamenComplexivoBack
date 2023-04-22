package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "A1PlanRotacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class A1_PlanRotacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_A1PlanRotacion;
	private String objetivoEspeci;
	private String objetivoOperat;
	private String funcion;
	private String horas;
	private String semanas;

	private Long idanexo1;

}
