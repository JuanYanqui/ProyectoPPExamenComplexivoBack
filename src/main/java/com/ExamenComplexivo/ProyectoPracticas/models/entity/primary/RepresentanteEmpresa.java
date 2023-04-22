package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "representante_empresa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepresentanteEmpresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_representante;
	@Column(name = "cedula", nullable = false, updatable = false)
	private String cedula;
	private String nombrerep;
	private String apellidorep;
	private String correorep;
	private String direccionrep;
	private String telefonorep;
	private Long idempre;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date createat;

	@PrePersist
	public void prePersist() {
		createat = new Date();
	}
}
