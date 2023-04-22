package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Persona;

import java.util.List;

public interface IPersonaService {

	public List<Persona> findAll();

	public Persona save(Persona persona);

	public Persona findById(Long id);

	public void delete(Long id);
}
