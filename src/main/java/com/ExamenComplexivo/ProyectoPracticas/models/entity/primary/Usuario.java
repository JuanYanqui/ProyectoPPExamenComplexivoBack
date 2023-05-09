package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String cedula;
	private String nombres;
	private String apellidos;
	private String correo;
	private String carrera;
	private String contrasenia;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuarioRoles",
			joinColumns = @JoinColumn(name = "idUsuario"),
			inverseJoinColumns = @JoinColumn(name = "idRol"))
	private Set<Rol> roles = new HashSet<>();

	//Relacionado con responsable de ppp un a uno
	@JsonIgnore
	@OneToMany(mappedBy = "usuario_responsable",cascade = CascadeType.ALL)
	private List<Responsable_PPP> responsablePPP;


	//Relacionado con estudiante practicante uno a uno
	@JsonIgnore
	@OneToOne(mappedBy = "usuario_estudiante_practicante")
	private Estudiante_Practicante estudiantePracticante;


	//Relacionado de uno a uno con tutor empresarial
	@JsonIgnore
	@OneToMany(mappedBy = "usuario_empresarial",cascade = CascadeType.ALL)
	private List<Tutor_Empresarial> tutorEmpresarial;

	//Relacionado con solicitud convocatoria de uno a muchos
	@JsonIgnore
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
	private List<Solicitud_Convocatoria> solicitudConvocatorias;

	//Relacionado con solicitud convocatoria de uno a muchos
	@JsonIgnore
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
	private List<Practica> practicas;


	public Usuario(String cedula, String nombre, String apellido, String carrera, String contrasenia, String correo, Personas_empresa usuario_persona_empresa) {
		this.cedula = cedula;
		this.nombres = nombre;
		this.apellidos = apellido;
		this.carrera = carrera;
		this.contrasenia = contrasenia;
		this.correo = correo;
		this.usuario_persona_empresa = usuario_persona_empresa;
	}

	//Relacion de usuario con persona empresa 1:1
	@OneToOne
	@JoinColumn(name = "idpersonaemp")
	private Personas_empresa usuario_persona_empresa;

}
