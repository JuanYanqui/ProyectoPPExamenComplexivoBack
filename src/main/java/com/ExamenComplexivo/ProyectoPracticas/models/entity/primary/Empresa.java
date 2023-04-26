package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmpresa;
    private String ruc_empresa;
    private String nombre_empresa;
    private String correo;
    private String ciudad;
    private String numero_telefono;
    private String direccion;
    private String codigo_postal;
    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Detalle_Convenio> detalleConvenios;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Tutor_Empresarial> tutorEmpresarials;
}
