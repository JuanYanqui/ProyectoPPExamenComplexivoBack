package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.MateriaAprobada;

import java.util.List;

public interface IMateriaAprobadaService {

	public List<MateriaAprobada> findAll();

	public MateriaAprobada save(MateriaAprobada materia);

	public MateriaAprobada findById(Long id);

	public void delete(Long id);
}
