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
@Table(name = "convenio")
public class Convenio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idConvenio;
    private Integer numero_convenio;
    private Date fecha_elaboracion;
    private Integer numero_itv;
    private String descripcion;

    private boolean estado;

    private byte documento_convenio;


    //Relacion de uno a uno con detalle convenio
    @JsonIgnore
    @OneToOne(mappedBy = "convenio")
    private Detalle_Convenio detalleConvenio;





}
