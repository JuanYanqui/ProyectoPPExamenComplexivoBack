package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rol")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long idRol;
	private String rolNombre;

	@JsonIgnore
	@OneToOne(mappedBy = "rol")
	private Usuario usuario;


}
