package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Detalle_Practica;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "anexo8")
public class Anexo8 {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo8;
	private String conclusiones;
	private String tiempo_duracion;

	private byte documento_anexo8;

	@OneToOne
	@JoinColumn(name = "idDetallePractica")
	private Detalle_Practica detallePractica;

}
