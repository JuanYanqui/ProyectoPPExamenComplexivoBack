package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "practicas")
public class Practicas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_practicas;
	private Long id_tutor_academico;
	private Long id_tutor_empresarial;
	private Long id_convenio;
	private String lugar;
	private String cantidad_horas;
	private String fecha_inicio;
	private String fecha_final;
	private String carrera_solicitada;
	private String cantidad_estudiantes;
	private String actividades;

	public Long getId_practicas() {
		return id_practicas;
	}

	public void setId_practicas(Long id_practicas) {
		this.id_practicas = id_practicas;
	}

	public Long getId_tutor_academico() {
		return id_tutor_academico;
	}

	public void setId_tutor_academico(Long id_tutor_academico) {
		this.id_tutor_academico = id_tutor_academico;
	}

	public Long getId_tutor_empresarial() {
		return id_tutor_empresarial;
	}

	public void setId_tutor_empresarial(Long id_tutor_empresarial) {
		this.id_tutor_empresarial = id_tutor_empresarial;
	}

	public Long getId_convenio() {
		return id_convenio;
	}

	public void setId_convenio(Long id_convenio) {
		this.id_convenio = id_convenio;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCantidad_horas() {
		return cantidad_horas;
	}

	public void setCantidad_horas(String cantidad_horas) {
		this.cantidad_horas = cantidad_horas;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_final() {
		return fecha_final;
	}

	public void setFecha_final(String fecha_final) {
		this.fecha_final = fecha_final;
	}

	public String getCarrera_solicitada() {
		return carrera_solicitada;
	}

	public void setCarrera_solicitada(String carrera_solicitada) {
		this.carrera_solicitada = carrera_solicitada;
	}

	public String getCantidad_estudiantes() {
		return cantidad_estudiantes;
	}

	public void setCantidad_estudiantes(String cantidad_estudiantes) {
		this.cantidad_estudiantes = cantidad_estudiantes;
	}

	public String getActividades() {
		return actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	

}
