package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "anexo4")
public class Anexo4 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_anexo4;
	private String carrera;
	private Long id_docente;
	private Long id_representante;
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	public Long getId_anexo4() {
		return id_anexo4;
	}

	public void setId_anexo4(Long id_anexo4) {
		this.id_anexo4 = id_anexo4;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Long getId_docente() {
		return id_docente;
	}

	public void setId_docente(Long id_docente) {
		this.id_docente = id_docente;
	}

	public Long getId_representante() {
		return id_representante;
	}

	public void setId_representante(Long id_representante) {
		this.id_representante = id_representante;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
