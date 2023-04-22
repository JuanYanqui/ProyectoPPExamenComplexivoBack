package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	private String username;
	private String password;
	private String nombre;
	private String apellido;
	private boolean enabled = true;
	private String correo;
	private String numcelular;
	@Column(name = "fechanac")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_nac;


	public Usuario() {

	}
}