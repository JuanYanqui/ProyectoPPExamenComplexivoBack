package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class vNombreEmpresaRepre {
	@Id
	private String NombreEmpresa;
	private String NombreRepresentante;
	private String ApellidoRepresentante;
	

}
