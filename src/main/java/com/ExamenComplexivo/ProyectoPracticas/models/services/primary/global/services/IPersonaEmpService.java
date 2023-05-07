package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;


import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Personas_empresa;

import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

public interface IPersonaEmpService extends IGenericService<Personas_empresa,Long> {
    Personas_empresa findbyCedula(String cedula);
    Personas_empresa findbyCorreo(String correo);
}
