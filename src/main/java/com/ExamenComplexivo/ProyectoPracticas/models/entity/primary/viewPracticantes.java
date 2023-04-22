package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "list_practicantes_view_m")
@NoArgsConstructor
@AllArgsConstructor
public class viewPracticantes {

	@Id
	private int idrealizando;
	private int idpractica;
	private int idpracticante;
	private int idpersona;
	private String nombre;
	private String identificacion;
	private String empresas;

}
