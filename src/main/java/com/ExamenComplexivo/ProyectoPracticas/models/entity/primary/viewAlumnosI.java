package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "viewalumnos")
@NoArgsConstructor
@AllArgsConstructor
public class viewAlumnosI {

	@Id
	@Column(name = "cedula", nullable = false, updatable = false)
	private String cedula;
	private String primerApellido;
	private String segundoApellido;
	private String primerNombre;
	private String segundoNombre;
	private String descripcion;
	private String correo;
}
