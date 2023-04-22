package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verpersonaf;

import java.util.List;

public interface IDocenteFenixService {
	
	public List<verpersonaf> findAll();

	public verpersonaf findById(String cedula);

}
