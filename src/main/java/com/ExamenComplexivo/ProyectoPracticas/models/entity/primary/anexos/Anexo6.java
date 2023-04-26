package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Detalle_Practica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "anexo6")
public class Anexo6 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo6;
	private Integer numero_semana;

	private String dia;

	private Date hora_ingreso;

	private Date hora_salida;

	private Integer horas_diarias;

	private Integer total_horas;

	private byte documento_anexo6;

	@ManyToOne
	@JoinColumn(name = "idDetallePractica",referencedColumnName = "idDetallePractica")
	private Detalle_Practica detallePractica;
}
