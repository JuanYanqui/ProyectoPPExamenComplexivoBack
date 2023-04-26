package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "detalle_convenio")
public class Detalle_Convenio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDetalleConvenio;
    private Date fecha_aprobacion;
    private Date fecha_caducidad;

    @OneToOne
    @JoinColumn(name = "idConvenio")
    private Convenio convenio;

    @ManyToOne
    @JoinColumn(name = "idEmpresa",referencedColumnName = "idEmpresa")
    private Empresa empresa;
}
