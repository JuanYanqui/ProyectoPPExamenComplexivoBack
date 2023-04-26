package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Detalle_Practica;
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
@Table(name = "anexo7")
public class Anexo7 {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo7;
	private String parametro_calificar;
	private Double calificacion;
	private Double puntaje_total;

	private byte documento_anexo7;

	@OneToOne
	@JoinColumn(name = "idDetallePractica")
	private Detalle_Practica detallePractica;

}
