package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "realiza_pract")
public class RealizaPractica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_practica_real;
	private Long id_estudiante;
	private Long id_practica;

	public Long getId_practica_real() {
		return id_practica_real;
	}

	public void setId_practica_real(Long id_practica_real) {
		this.id_practica_real = id_practica_real;
	}

	public Long getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(Long id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public Long getId_practica() {
		return id_practica;
	}

	public void setId_practica(Long id_practica) {
		this.id_practica = id_practica;
	}
}
