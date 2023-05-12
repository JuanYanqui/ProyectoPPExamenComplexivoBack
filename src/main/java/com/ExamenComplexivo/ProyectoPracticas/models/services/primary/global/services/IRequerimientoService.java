package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Requerimientos;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

import java.util.List;

public interface IRequerimientoService extends IGenericService<Requerimientos,Long> {
    List<Requerimientos> findByRequerimientosPorSolicitud(Long idsolicitud);
}
