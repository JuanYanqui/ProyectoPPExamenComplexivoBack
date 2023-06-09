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
	private String correo;
	private String username;
	private String contrasenia;
	private String estado;


	//Relacionado con rol de uno a uno
	@OneToOne
	@JoinColumn(name = "idRol")
	private Rol rol;

	//Relacionado con responsable de ppp un a uno
	@JsonIgnore
	@OneToOne(mappedBy = "usuario")
	private Responsable_PPP responsablePPP;

	//Relacionado con estudiante practicante uno a uno
	@JsonIgnore
	@OneToOne(mappedBy = "usuario_estudiante_practicante")
	private Estudiante_Practicante estudiantePracticante;


	//Relacionado de uno a uno con tutor empresarial
	@JsonIgnore
	@OneToOne(mappedBy = "usuario_tutor_empresarial")
	private Tutor_Empresarial tutorEmpresarial;

	//Relacionado con solicitud convocatoria de uno a muchos
	@JsonIgnore
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
	private List<Solicitud_Convocatoria> solicitudConvocatorias;

	//Relacionado con solicitud convocatoria de uno a muchos
	@JsonIgnore
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
	private List<Practica> practicas;


	public Usuario(Long idUsuario, String cedula, String correo, String username, String contrasenia, String estado) {
		this.idUsuario = idUsuario;
		this.cedula = cedula;
		this.correo = correo;
		this.username = username;
		this.contrasenia = contrasenia;
		this.estado = estado;
	}
}