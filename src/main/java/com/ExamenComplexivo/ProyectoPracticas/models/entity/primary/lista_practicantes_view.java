package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class lista_practicantes_view {

	
	@Id
	private int idrealizando;
	private int idpractica;
	private int idpracticante;
	@Nullable
	private Long idanexo;
	private int idpersona;
	private String apellidouno;
	private String apellidodos;
	private String nombreuno;
	private String nombredos;
	private int numconvenio;
	private String identicacion;
	private String empresas;
	
	
	private String correo;
	private String carrera;
	private Date fechafin;
	private Date fechainicio;
	private String descripcion;
	
	private Long numitv;

	public int getIdrealizando() {
		return idrealizando;
	}

	public void setIdrealizando(int idrealizando) {
		this.idrealizando = idrealizando;
	}

	public int getIdpractica() {
		return idpractica;
	}

	public void setIdpractica(int idpractica) {
		this.idpractica = idpractica;
	}

	public int getIdpracticante() {
		return idpracticante;
	}

	public void setIdpracticante(int idpracticante) {
		this.idpracticante = idpracticante;
	}

	public Long getIdanexo() {
		return idanexo;
	}

	public void setIdanexo(Long idanexo) {
		this.idanexo = idanexo;
	}

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getApellidouno() {
		return apellidouno;
	}

	public void setApellidouno(String apellidouno) {
		this.apellidouno = apellidouno;
	}

	public String getApellidodos() {
		return apellidodos;
	}

	public void setApellidodos(String apellidodos) {
		this.apellidodos = apellidodos;
	}

	public String getNombreuno() {
		return nombreuno;
	}

	public void setNombreuno(String nombreuno) {
		this.nombreuno = nombreuno;
	}

	public String getNombredos() {
		return nombredos;
	}

	public void setNombredos(String nombredos) {
		this.nombredos = nombredos;
	}

	public String getIdenticacion() {
		return identicacion;
	}

	public void setIdenticacion(String identicacion) {
		this.identicacion = identicacion;
	}

	public String getEmpresas() {
		return empresas;
	}

	public void setEmpresas(String empresas) {
		this.empresas = empresas;
	}

	public int getNumconvenio() {
		return numconvenio;
	}

	public void setNumconvenio(int numconvenio) {
		this.numconvenio = numconvenio;
	}

	public Long getNumitv() {
		return numitv;
	}

	public void setNumitv(Long numitv) {
		this.numitv = numitv;
	}

	

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	

}
