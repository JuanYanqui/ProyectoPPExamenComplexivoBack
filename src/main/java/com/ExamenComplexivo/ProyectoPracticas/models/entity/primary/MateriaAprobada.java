package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "materia_aprov")
public class MateriaAprobada implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_materia;
	private Long id_practicante;

	public Long getId_materia() {
		return id_materia;
	}

	public void setId_materia(Long id_materia) {
		this.id_materia = id_materia;
	}

	public Long getId_practicante() {
		return id_practicante;
	}

	public void setId_practicante(Long id_practicante) {
		this.id_practicante = id_practicante;
	}
}
