package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practicante;

import java.util.List;

public interface IPracticanteService {

	public List<Practicante> findAll();
	
	public Practicante save(Practicante practicante);

	public Practicante findById(Long id);

	public void delete(Long id);
}
