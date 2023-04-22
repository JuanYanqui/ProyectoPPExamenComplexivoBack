package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "anexo5")
public class Anexo5 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_anexo5;
	private String descripcion_doc;
	private String estado_firma;
	private Long id_ente_empresa;
	private Long id_tutor_academico;
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	public Long getId_anexo5() {
		return id_anexo5;
	}

	public void setId_anexo5(Long id_anexo5) {
		this.id_anexo5 = id_anexo5;
	}

	public String getDescripcion_doc() {
		return descripcion_doc;
	}

	public void setDescripcion_doc(String descripcion_doc) {
		this.descripcion_doc = descripcion_doc;
	}

	public String getEstado_firma() {
		return estado_firma;
	}

	public void setEstado_firma(String estado_firma) {
		this.estado_firma = estado_firma;
	}

	public Long getId_ente_empresa() {
		return id_ente_empresa;
	}

	public void setId_ente_empresa(Long id_ente_empresa) {
		this.id_ente_empresa = id_ente_empresa;
	}

	public Long getId_tutor_academico() {
		return id_tutor_academico;
	}

	public void setId_tutor_academico(Long id_tutor_academico) {
		this.id_tutor_academico = id_tutor_academico;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
