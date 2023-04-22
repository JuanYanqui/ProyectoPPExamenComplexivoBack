package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "viewcoordinadoresi")
@NoArgsConstructor
@AllArgsConstructor
public class viewCoordinadoresI {

	@Id
	@Column(name = "cedula", nullable = false, updatable = false)
	private String cedula;
	private String per_primerapellido;
	private String per_segundoapellido;
	private String per_primernombre;
	private String per_segundonombre;
	private String carrera_codigo;
}
