package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Estudiante_Practicante;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

import java.util.List;

public interface IEstudiantePracticanteService extends IGenericService<Estudiante_Practicante,Long> {
    List<Estudiante_Practicante> findByCedula(String cedula);

    Long findIdByCedula(String cedula);
}
