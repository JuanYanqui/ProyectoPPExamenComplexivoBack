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
@Table(name = "tutor_empresarial")
public class Tutor_Empresarial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTutorEmpresarial;
    private String departamento;
    private  byte titulo;
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "idEmpresa",referencedColumnName = "idEmpresa")
    private Empresa empresa;

    @JsonIgnore
    @OneToMany(mappedBy = "tutorEmpresarial",cascade = CascadeType.ALL)
    private List<Solicitud_Practicas> solicitudPracticas;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario_tutor_empresarial;

    @JsonIgnore
    @OneToOne(mappedBy = "tutorEmpresarial")
    private Aprobacion_Empresa aprobacionEmpresa;

    @JsonIgnore
    @OneToOne(mappedBy = "tutorEmpresarial")
    private Detalle_Practica detallePractica;
}
