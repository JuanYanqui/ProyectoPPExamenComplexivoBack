package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.verEmpresas;

import java.util.List;


public interface IverEmpresaService {
	
	public List<verEmpresas> findAll();
	
	public int findByName(String name);
	
}
