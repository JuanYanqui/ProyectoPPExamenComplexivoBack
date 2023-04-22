package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personas")
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_persona;
	private String cedula;
	private String primer_nombre;
	private String segundo_nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String rol_nombre;
	private String estado;
	private String email;
	private int celular;
	private String telefono;
	private String sexo;
	private String genero;
	private String idioma;
	private byte foto;
	@Column(name = "fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fecha_registro;

}
