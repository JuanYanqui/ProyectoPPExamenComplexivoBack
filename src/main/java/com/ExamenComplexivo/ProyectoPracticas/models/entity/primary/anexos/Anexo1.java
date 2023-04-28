package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "anexo1")
@Data
@Getter
@Setter
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

	private byte documento_anexo1;

	@OneToOne
	@JoinColumn(name = "idPractica")
	private Practica practica;

}
