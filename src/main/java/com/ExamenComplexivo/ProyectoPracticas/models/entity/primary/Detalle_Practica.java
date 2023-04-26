package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.*;
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
@Table(name = "detalle_practica")
public class Detalle_Practica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDetallePractica;
    private String horario;

    @OneToOne
    @JoinColumn(name = "idTutorEmpresarial")
    private Tutor_Empresarial tutorEmpresarial;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario_tutor_academico;

    @OneToOne
    @JoinColumn(name = "idAprobacionEmpresa")
    private Aprobacion_Empresa aprobacionEmpresa;








    @JsonIgnore
    @OneToOne(mappedBy = "detallePractica")
    private Anexo1 anexo1;

    @JsonIgnore
    @OneToOne(mappedBy = "detallePractica")
    private Anexo2 anexo2;

    @JsonIgnore
    @OneToOne(mappedBy = "detallePractica")
    private Anexo3 anexo3;

    @JsonIgnore
    @OneToOne(mappedBy = "detallePractica")
    private Anexo4 anexo4;

    @JsonIgnore
    @OneToOne(mappedBy = "detallePractica")
    private Anexo5 anexo5;

    @JsonIgnore
    @OneToMany(mappedBy = "detallePractica",cascade = CascadeType.ALL)
    private List<Anexo6> anexo6;

    @JsonIgnore
    @OneToOne(mappedBy = "detallePractica")
    private Anexo7 anexo7;

    @JsonIgnore
    @OneToOne(mappedBy = "detallePractica")
    private Anexo8 anexo8;
}


