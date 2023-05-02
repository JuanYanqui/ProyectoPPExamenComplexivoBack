package com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "verestudiantef")
@NoArgsConstructor
@AllArgsConstructor
public class verestudiantef {

	@Id
	@Column(name = "cedula", nullable = false,updatable = false)
	private String cedula;
	private String correo_institucional;
	private String nombres;
	private String apellidos;
	private String carrera;
	

}
