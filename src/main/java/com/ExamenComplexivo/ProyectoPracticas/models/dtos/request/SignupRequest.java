package com.ExamenComplexivo.ProyectoPracticas.models.dtos.request;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Personas_empresa;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter
@Getter
public class SignupRequest {

    @NotBlank
    private String cedula;
    @NotBlank
    private String nombres;
    @NotBlank
    private String apellidos;
    @NotBlank
    @Email
    private String correo;

    @NotBlank
    private String carrera;
    @NotBlank
    private String contrasenia;
    @NotBlank
    private Personas_empresa persona_empresa;
    @NotNull
    private Set<String> roles;

}
