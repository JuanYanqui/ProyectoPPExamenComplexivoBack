package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actividades")
public class Actividades {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idActividades;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idSolicitudPracticas",referencedColumnName = "idSolicitudPracticas")
    private Solicitud_Practicas solicitudPracticas;

    @JsonIgnore
    @OneToMany(mappedBy = "actividades",cascade = CascadeType.ALL)
    private List<Detalle_Actividades> detalleActividades;

}
