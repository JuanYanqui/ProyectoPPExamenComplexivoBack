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
@Table(name = "personas_emp",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "cedula"),
                @UniqueConstraint(columnNames = "correo")
        })
public class Personas_empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpersonaemp;
    private String cedula;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String genero;
    private String correo;
    @Column(name = "foto", nullable = true)
    private String foto;

    @JsonIgnore
    @OneToOne(mappedBy = "usuario_persona_empresa")
    private Usuario usuario;


}
