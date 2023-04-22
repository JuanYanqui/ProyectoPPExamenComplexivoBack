package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ente_empresarial")
public class EnteEmpresarial implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_ente_empresa;
	private String primer_nombre;
	private String segundo_nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String rol;
	private Long id_empresa;
	private Long id_persona;
	private Long id_representante;

	public Long getId_ente_empresa() {
		return id_ente_empresa;
	}

	public void setId_ente_empresa(Long id_ente_empresa) {
		this.id_ente_empresa = id_ente_empresa;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Long getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public Long getId_persona() {
		return id_persona;
	}

	public void setId_persona(Long id_persona) {
		this.id_persona = id_persona;
	}

	public Long getId_representante() {
		return id_representante;
	}

	public void setId_representante(Long id_representante) {
		this.id_representante = id_representante;
	}

	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}

	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	public String getSegundo_apellido() {
		return segundo_apellido;
	}

	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

}
