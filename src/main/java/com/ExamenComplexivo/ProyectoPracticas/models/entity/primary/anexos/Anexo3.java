package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "anexo3")
public class Anexo3{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo3;
	private byte documentoAnexo3;
}
