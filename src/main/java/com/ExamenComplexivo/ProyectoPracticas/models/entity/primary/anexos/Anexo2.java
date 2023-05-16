package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "anexo2")
public class Anexo2 {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnexo2;


	@Column(nullable = true)
	private byte documento_anexo2;


	@OneToOne
	@JoinColumn(name = "idPractica", nullable = true)
	private Practica practica;

}
