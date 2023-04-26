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
@Table(name = "convenio")
public class Convenio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idConvenio;
    private Integer numero_convenio;
    private Date fecha_elaboracion;
    private Integer numero_itv;
    private String descripcion;
    private byte documento;

    @OneToOne
    @JoinColumn(name = "idDetalleConvenio")
    private Detalle_Convenio detalleConvenio;





}
