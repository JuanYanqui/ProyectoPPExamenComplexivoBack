package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "anexo4")
public class Anexo4 {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo4;
	private Date fecha_actual;
	private byte documento_anexo4;

	@OneToOne
	@JoinColumn(name = "idPractica")
	private Practica practica;
}
