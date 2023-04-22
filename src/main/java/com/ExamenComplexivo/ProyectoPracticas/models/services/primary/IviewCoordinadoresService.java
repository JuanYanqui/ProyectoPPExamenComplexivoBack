package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.viewCoordinadoresI;

import java.util.List;

public interface IviewCoordinadoresService {

	public List<viewCoordinadoresI> findAll();

	viewCoordinadoresI findByIdentificacion(String identificacion);
}
