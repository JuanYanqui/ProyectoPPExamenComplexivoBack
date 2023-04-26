package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

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
@Table(name = "anexo5")
public class Anexo5 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo5;
	private Date fecha_actual;
	private Date fecha_desde;
	private Date hasta;
	private String actividades_seguimiento;
	private String observaciones;

	private byte documento_anexo5;

	@OneToOne
	@JoinColumn(name = "idDetallePractica")
	private Detalle_Practica detallePractica;

}
