package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "cedula"),
				@UniqueConstraint(columnNames = "correo")
		})
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	private String cedula;
	private String nombres;
	private String apellidos;
	private String correo;
	private String contrasenia;

	@OneToOne
	@JoinColumn(name = "idRol")
	private Rol rol;


	@JsonIgnore
	@OneToMany(mappedBy = "usuario_cord_vin",cascade = CascadeType.ALL)
	private List<Convenio> convenios;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario_responsable_pp",cascade = CascadeType.ALL)
	private List<Solicitud_Practicas> solicitudPracticas;

	@JsonIgnore
	@OneToOne(mappedBy = "usuario_estudiante_practicante")
	private Estudiante_Practicante estudiantePracticante;

	@JsonIgnore
	@OneToOne(mappedBy = "usuario_tutor_empresarial")
	private Tutor_Empresarial tutorEmpresarial;

	@JsonIgnore
	@OneToOne(mappedBy = "usuario_director")
	private Aprobacion_Estudiante aprobacionEstudiante_dir;


	@JsonIgnore
	@OneToOne(mappedBy = "usuario_responsable")
	private Aprobacion_Estudiante aprobacionEstudiante_res;

	@JsonIgnore
	@OneToOne(mappedBy = "usuario_tutor_academico")
	private Detalle_Practica detallePractica;

	public Usuario(String cedula, String nombre, String apellido, String contrasenia, String correo) {
		this.cedula = cedula;
		this.nombres = nombre;
		this.apellidos = apellido;
		this.contrasenia = contrasenia;
		this.correo = correo;
	}
}