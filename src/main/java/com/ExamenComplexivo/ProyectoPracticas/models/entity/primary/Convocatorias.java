package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "convocatorias")
public class Convocatorias {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idConvocatorias;
    private String nombre_convocatoria;
    private Date fecha_envio;
    private String descripcion;

    private byte documento_convocatoria;


    @OneToOne
    @JoinColumn(name = "idSolicitudPracticas")
    private Solicitud_Practicas solicitudPracticas;


    @JsonIgnore
    @OneToMany(mappedBy = "convocatorias",cascade = CascadeType.ALL)
    private List<Detalle_Materia> detalleMaterias;

    @JsonIgnore
    @ManyToOne
    private Solicitud_Convocatoria solicitudConvocatoria;
}
