package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "anexo1")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anexo1 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_anexo1;
	private Long id_practica_real;
	private String estado_firma;
	private String url_doc;
	private boolean estado;

}
