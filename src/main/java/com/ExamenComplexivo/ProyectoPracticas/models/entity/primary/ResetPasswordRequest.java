package com.ExamenComplexivo.ProyectoPracticas.models.entity.primary;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequest {

    private String cedula;
    private String newPassword;

    public ResetPasswordRequest() {

    }

    public ResetPasswordRequest(String cedula, String newPassword) {
        this.cedula = cedula;
        this.newPassword = newPassword;
    }
}
