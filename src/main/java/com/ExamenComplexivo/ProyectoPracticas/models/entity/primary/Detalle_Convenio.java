package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detalle_convenio")
public class Detalle_Convenio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleConvenio;

    private String fechaAprobacion;

    private String fecha_caducidad;
    private String nombre_carrera;

    //Relacionado con convenio de uno a uno
    @OneToOne
    @JoinColumn(name = "idConvenio")
    private Convenio convenio;


    //Relacionado con empresa de machos a uno
    @ManyToOne
    @JoinColumn(name = "idEmpresa",referencedColumnName = "idEmpresa")
    private Empresa empresa;
}
