package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aprobacion_empresa")
public class Aprobacion_Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAprobacionEmpresa;
    private Date fecha;
    private String estado;
}
