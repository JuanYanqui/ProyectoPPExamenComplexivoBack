package com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "vpersonas_ista")
@NoArgsConstructor
@AllArgsConstructor
public class verpersonaf {

	@Id
	@Column(name = "cedula", nullable = false, updatable = false)
	private String cedula;
	private String correo_institucional;
	private String nombres;
	private String apellidos;
}