package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
	private byte documento_anexo3;

	@OneToOne
	@JoinColumn(name = "idPractica")
	private Practica practica;
}
