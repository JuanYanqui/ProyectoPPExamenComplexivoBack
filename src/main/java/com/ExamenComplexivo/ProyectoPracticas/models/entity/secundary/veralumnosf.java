package com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class veralumnosf {
	
	@Id
	private String cedula;
	private String nombre_completo;
	private String car_descripcion;
	private String per_correo;
	

}
