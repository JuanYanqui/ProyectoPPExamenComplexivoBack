package com.ExamenComplexivo.ProyectoPracticas.models.dtos.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class LoginRequest {

    @NotBlank
    private String correo;
    @NotBlank
    private String contrasenia;

}
