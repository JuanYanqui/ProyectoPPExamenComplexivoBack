package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.viewAlumnosI;

import java.util.List;

public interface IviewAlumnosService {

	public List<viewAlumnosI> findAll();

	viewAlumnosI findByIdentificaion(String identificacion);

}
