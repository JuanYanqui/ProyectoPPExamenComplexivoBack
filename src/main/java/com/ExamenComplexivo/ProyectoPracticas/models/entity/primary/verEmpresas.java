package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import javax.persistence.*;

@Entity
public class verEmpresas {

	@Id
	private int id_empresa;
	private String nombre_emp;

	public int getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getNombre_emp() {
		return nombre_emp;
	}

	public void setNombre_emp(String nombre_emp) {
		this.nombre_emp = nombre_emp;
	}

}
