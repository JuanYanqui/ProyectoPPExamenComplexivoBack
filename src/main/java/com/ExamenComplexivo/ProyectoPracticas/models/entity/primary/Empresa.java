package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;
    //@Pattern(regexp = "^[0-9]{13}$", message = "RUC longitud permitida de 13 digitos")
    private String rucEmpresa;
    private String nombreEmpresa;
    //@Email(message = "El correo electrónico no tiene un formato válido.")
    private String correo;
    private String ciudad;
    //@Pattern(regexp = "^[0-9]{1,10}$", message = "El número de teléfono debe contener máximo 10 dígitos numéricos.")
    private String numeroTelefono;
    private String direccion;
    //@Pattern(regexp = "^[0-9]{6}$", message = "El código postal debe contener 6 dígitos numéricos.")
    private String codigoPostal;
    private String descripcion;

    private boolean status;



    //Relacionado con detalle convenio de uno a muchos
    @JsonIgnore
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Detalle_Convenio> detalleConvenios;


    //Relacionado con tutor empresarial de uno a muchos
    @JsonIgnore
    @OneToMany(mappedBy = "empresa",cascade = CascadeType.ALL)
    private List<Tutor_Empresarial> tutorEmpresarials;
}
