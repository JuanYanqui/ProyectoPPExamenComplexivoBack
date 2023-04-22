package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "convenios")
public class Convenio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_convenio;
	private int numero_convenio;
	private int numero_itv;
	private String descripcion;
	private int id_empresa;
	private String id_coordinador;

	public Long getId_convenio() {
		return id_convenio;
	}

	public void setId_convenio(Long id_convenio) {
		this.id_convenio = id_convenio;
	}

	public int getNumero_convenio() {
		return numero_convenio;
	}

	public void setNumero_convenio(int numero_convenio) {
		this.numero_convenio = numero_convenio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getId_coordinador() {
		return id_coordinador;
	}

	public void setId_coordinador(String id_coordinador) {
		this.id_coordinador = id_coordinador;
	}

	public int getNumero_itv() {
		return numero_itv;
	}

	public void setNumero_itv(int numero_itv) {
		this.numero_itv = numero_itv;
	}

}
