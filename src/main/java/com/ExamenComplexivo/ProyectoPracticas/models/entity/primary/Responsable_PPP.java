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
@Table(name = "responsable_ppp")
public class Responsable_PPP implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsablePPP;
    private String carrera;


    //Relacion con usuario de uno a uno
    @ManyToOne
    @JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario")
    private Usuario usuario_responsable;

    //Relacionado con solicitud de practicass de uno a muchos
    @JsonIgnore
    @OneToMany(mappedBy = "responsablePPP",cascade = CascadeType.ALL)
    private List<Solicitud_Practicas> solicitudPracticas;


    //Relacionado con solicitud convocatoria de uno a muchos
    @JsonIgnore
    @OneToMany(mappedBy = "responsablePPP",cascade = CascadeType.ALL)
    private List<Solicitud_Convocatoria> solicitudConvocatorias;
}
