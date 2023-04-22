package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="verdocentei")
@NoArgsConstructor
@AllArgsConstructor
public class verDocentes {
	
	@Id
	private Long id_persona;
	private Long id_docente;
	private String persona_identificacion;
	private String persona_primer_nombre;
	private String persona_primer_apellido;
	private String docente_abreviatura;
	private String docente_titulo;
	
}
