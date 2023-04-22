package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "anexo7p1")
public class Anexo7p1_Evalua implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_anexo7p1;
	private String parametro;
	private String calificacion;
	private Double calificacion_total;
	private Long id_practica_real;

	public Long getId_anexo7p1() {
		return id_anexo7p1;
	}

	public void setId_anexo7p1(Long id_anexo7p1) {
		this.id_anexo7p1 = id_anexo7p1;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public Double getCalificacion_total() {
		return calificacion_total;
	}

	public void setCalificacion_total(Double calificacion_total) {
		this.calificacion_total = calificacion_total;
	}

	public Long getId_practica_real() {
		return id_practica_real;
	}

	public void setId_practica_real(Long id_practica_real) {
		this.id_practica_real = id_practica_real;
	}
}
