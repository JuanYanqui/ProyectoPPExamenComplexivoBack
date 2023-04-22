package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "estpraticante")
public class Practicante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_practicante;
	private String ciclo;
	@Column(name = "fecha_inicio")
	@Temporal(TemporalType.DATE)
	private Date fecha_inicio;
	@Column(name = "fecha_fin")
	@Temporal(TemporalType.DATE)
	private Date fecha_fin;
	private String ciclo_academico;
	private String carrera;
	private String periodo_academico;
	private Long id_persona;

	public Long getId_practicante() {
		return id_practicante;
	}

	public void setId_practicante(Long id_practicante) {
		this.id_practicante = id_practicante;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getCiclo_academico() {
		return ciclo_academico;
	}

	public void setCiclo_academico(String ciclo_academico) {
		this.ciclo_academico = ciclo_academico;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getPeriodo_academico() {
		return periodo_academico;
	}

	public void setPeriodo_academico(String periodo_academico) {
		this.periodo_academico = periodo_academico;
	}

	public Long getId_persona() {
		return id_persona;
	}

	public void setId_persona(Long id_persona) {
		this.id_persona = id_persona;
	}
}
