package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "materias")
public class Estudiante_Practicante {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long idEstudiantePracticas;
        private Boolean Estado;


        @OneToOne
        @JoinColumn(name = "idUsuario")
        private Usuario usuario_estudiante_practicante;

        @JsonIgnore
        @ManyToOne
        private Solicitud_Convocatoria solicitudConvocatoria;

}


