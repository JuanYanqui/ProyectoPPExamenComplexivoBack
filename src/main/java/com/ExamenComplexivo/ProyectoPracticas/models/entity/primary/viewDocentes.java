package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@Table(name = "verdocente")
@NoArgsConstructor
@AllArgsConstructor
public class viewDocentes {
	@Id
	private String cedula;
	private String primernombre ;
	private String primerapellido;
	private String abreviatura;
	private String titulo;
	private int categoria;
}
