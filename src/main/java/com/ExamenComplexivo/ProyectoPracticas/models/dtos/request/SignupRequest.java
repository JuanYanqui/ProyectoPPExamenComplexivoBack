package com.ExamenComplexivo.ProyectoPracticas.models.dtos.request;

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
    @NotNull
    private Set<String> roles;

}
