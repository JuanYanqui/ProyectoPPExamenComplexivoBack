package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Empresa;

import java.util.List;

public interface IEmpresaService {

	public List<Empresa> findAll();

	public Empresa save(Empresa empresa);

	public Empresa findById(Long id);

	public void delete(Long id);
	
	public List<Empresa> findbyName(String name);
	
}
