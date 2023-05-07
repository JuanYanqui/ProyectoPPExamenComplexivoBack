package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "requerimientos")
public class Requerimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRequerimientos;

    //Relacionado con solicitud practicas muchos a uno
    @ManyToOne
    @JoinColumn(name = "idSolicitudPracticas",referencedColumnName = "idSolicitudPracticas")
    private Solicitud_Practicas solicitudPracticas;


    //Relacionado con actividades de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idActividades",referencedColumnName = "idActividades")
    private Actividades actividades;

}
