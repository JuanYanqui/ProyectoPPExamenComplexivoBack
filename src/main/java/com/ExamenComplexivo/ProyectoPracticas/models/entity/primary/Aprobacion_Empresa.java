package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aprobacion_empresa")
public class Aprobacion_Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAprobacionEmpresa;
    private Date fecha;
    private String estado;

    @OneToOne
    @JoinColumn(name = "idAprobacionEstudiante")
    private Aprobacion_Estudiante aprobacionEstudiante;

    @OneToOne
    @JoinColumn(name = "idTutorEmpresarial")
    private Tutor_Empresarial tutorEmpresarial;

    @OneToOne
    @JoinColumn(name = "idPractica")
    private Practica practica;

    @JsonIgnore
    @OneToOne(mappedBy = "aprobacionEmpresa")
    private Detalle_Practica detallePractica;


}
