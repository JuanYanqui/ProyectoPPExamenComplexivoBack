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
@Table(name = "estudiante_practicante")
public class Estudiante_Practicante implements Serializable {
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idEstudiantePracticas;
        private Boolean estado;

        //Relacionado con usuario de uno a uno
        @OneToOne
        @JoinColumn(name = "idUsuario")
        private Usuario usuario_estudiante_practicante;

        //Relacionado con solicitud convocatoria de muchos a uno
        @JsonIgnore
        @OneToMany(mappedBy = "estudiantePracticante",cascade = CascadeType.ALL)
        private List<Solicitud_Convocatoria> solicitudConvocatorias;
}


