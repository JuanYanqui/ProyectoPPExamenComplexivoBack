package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "anexo1")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anexo1 {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo1;
	private String itv;
	private Date fecha_inicio;
	private Date fecha_final;
	private String objetivos;
	private String actividades;
	private String areas;
	private Integer horas;

}
