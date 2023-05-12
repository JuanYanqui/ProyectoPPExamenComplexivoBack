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
@Table(name = "tutor_empresarial")
public class Tutor_Empresarial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTutorEmpresarial;
    private String departamento;
    private String titulo;
    private String numeroContacto;
    private String cargo;

    private boolean estado;


    //Relacionado con usuario de uno a uno
    @ManyToOne
    @JoinColumn(name = "idUsuario",referencedColumnName = "idUsuario")
    private Usuario usuario_empresarial;

    //Relacionado con empresa de muchos a uno
    @ManyToOne
    @JoinColumn(name = "idEmpresa",referencedColumnName = "idEmpresa")
    private Empresa empresa;

    //Relacionado con solicitud de practicass de uno a muchos
    @JsonIgnore
    @OneToMany(mappedBy = "tutorEmpresarial",cascade = CascadeType.ALL)
    private List<Solicitud_Practicas> solicitudPracticas;

    //Relacionado con solicitud convocatoria de uno a muchos
    @JsonIgnore
    @OneToMany(mappedBy = "tutorEmpresarial",cascade = CascadeType.ALL)
    private List<Solicitud_Convocatoria> solicitudConvocatorias;

    //Relacionado con practica de uno a muchos
    @JsonIgnore
    @OneToMany(mappedBy = "tutorEmpresarial",cascade = CascadeType.ALL)
    private List<Practica> practicas;



}
