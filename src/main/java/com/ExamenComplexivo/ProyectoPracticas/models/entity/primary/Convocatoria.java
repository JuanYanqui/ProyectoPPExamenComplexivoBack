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
@Table(name = "convocatorias")
public class Convocatoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_convocatoria;
	private Long id_representante;
	private Long id_practicas;
	@Column(name = "fecha_recepcion")
	@Temporal(TemporalType.DATE)
	private Date fecha_recepcion;
	@Column(name = "fecha_envio")
	@Temporal(TemporalType.DATE)
	private Date fecha_envio;
	private String listadoMaterias;
	private int ciclo;
	private String actividades;
	private String carrera;
	private String empresa;
	
	
}
