package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "solicitud_practica")
public class SolicitudPracticas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_solicitud;
	@Column(name = "fecha_envio")
	@Temporal(TemporalType.DATE)
	private Date fecha_envio;
	@Column(name = "fecha_resp")
	@Temporal(TemporalType.DATE)
	private Date fecha_resp;
	private String descripcion;
	private String estado;
	private Long id_practicante;
	private Long id_practica;

	public Long getId_solicitud() {
		return id_solicitud;
	}

	public void setId_solicitud(Long id_solicitud) {
		this.id_solicitud = id_solicitud;
	}

	public Date getFecha_envio() {
		return fecha_envio;
	}

	public void setFecha_envio(Date fecha_envio) {
		this.fecha_envio = fecha_envio;
	}

	public Date getFecha_resp() {
		return fecha_resp;
	}

	public void setFecha_resp(Date fecha_resp) {
		this.fecha_resp = fecha_resp;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getId_practicante() {
		return id_practicante;
	}

	public void setId_practicante(Long id_practicante) {
		this.id_practicante = id_practicante;
	}

	public Long getId_practica() {
		return id_practica;
	}

	public void setId_practica(Long id_practica) {
		this.id_practica = id_practica;
	}
}
