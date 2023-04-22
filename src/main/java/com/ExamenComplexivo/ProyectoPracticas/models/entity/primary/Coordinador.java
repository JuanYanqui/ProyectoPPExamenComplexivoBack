package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "coordinador")
public class Coordinador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_coordinador;
	private Date horario;
	private Long id_persona;

	public Long getId_coordinador() {
		return id_coordinador;
	}

	public void setId_coordinador(Long id_coordinador) {
		this.id_coordinador = id_coordinador;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Long getId_persona() {
		return id_persona;
	}

	public void setId_persona(Long id_persona) {
		this.id_persona = id_persona;
	}
}
