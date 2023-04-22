package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "representante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsableCarrera implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_representante;
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String direccion;
	private String telefono;

}
