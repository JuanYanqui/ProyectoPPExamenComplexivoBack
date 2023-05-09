package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convenio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "convenio")
public class Convenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConvenio;
    //@Pattern(regexp = "PPP-ISTA-\\d{1,}-\\d{4}", message = "El formato de numero de convenio ingresado no es válido.")
    private String numero_convenio;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha_elaboracion;
    //@Pattern(regexp = "SIES-ISTA-\\d{1,}-\\d{4}", message = "El formato de numero de ITV ingresado no es válido.")
    private String numero_itv;
    private String descripcion;
    private boolean estado;


    //Relacion de uno a uno con detalle convenio
    @JsonIgnore
    @OneToOne(mappedBy = "convenio")
    private Detalle_Convenio detalleConvenio;

    //Relacionado de uno a uno con documento_convenio
    @OneToOne
    @JoinColumn(name = "id_documentoCnv",nullable = true)
    private Documento_Convenio documentoConvenio;


}
