package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empresa")
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmpresa;
    private String rucEmpresa;
    private String nombreEmpresa;
    private String correo;
    private String ciudad;
    private String numeroTelefono;
    private String direccion;
    private String codigoPostal;
    private String descripcion;


    //Relacionado con detalle convenio de uno a muchos
    @JsonIgnore
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Detalle_Convenio> detalleConvenios;


    //Relacionado con tutor empresarial de uno a muchos
    @JsonIgnore
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Tutor_Empresarial> tutorEmpresarials;
}
