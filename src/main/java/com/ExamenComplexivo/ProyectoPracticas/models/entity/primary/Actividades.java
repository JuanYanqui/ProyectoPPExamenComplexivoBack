package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actividades")
public class Actividades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActividades;
    private String detalleActividad;
    private String herramientas;
    private String nombre_materia;

    //Relacionado con requerimientos de uno a muchos
    @JsonIgnore
    @OneToMany(mappedBy = "actividades",cascade = CascadeType.ALL)
    private List<Requerimientos> requerimientos;



}
