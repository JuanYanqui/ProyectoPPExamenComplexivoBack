package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "anexo3")
public class Anexo3 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_anexo3;
	private Long id_practicante;

	public Long getId_anexo3() {
		return id_anexo3;
	}

	public void setId_anexo3(Long id_anexo3) {
		this.id_anexo3 = id_anexo3;
	}

	public Long getId_practicante() {
		return id_practicante;
	}

	public void setId_practicante(Long id_practicante) {
		this.id_practicante = id_practicante;
	}
}
