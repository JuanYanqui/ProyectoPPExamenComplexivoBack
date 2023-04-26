package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudiante_practicante")
public class Estudiante_Practicante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEstudiantePracticante;
    private Boolean Estado;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;


}
