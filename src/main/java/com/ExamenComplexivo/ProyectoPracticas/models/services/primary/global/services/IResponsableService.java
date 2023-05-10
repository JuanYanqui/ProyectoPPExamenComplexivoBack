package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Responsable_PPP;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

import java.util.List;

public interface IResponsableService extends IGenericService<Responsable_PPP,Long> {

    List<String> getNombresCompletosDeResponsablesPorCarrera(String carrera);


    Integer buscarResponsablePorCarrera(String nombreCarrera);

    Responsable_PPP findByCedulaUsuario(String cedula);
}
