package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practicas;

import java.util.List;

public interface IPracticasService {

	public List<Practicas> findAll();

	public Practicas save(Practicas practicas);

	public Practicas findById(Long id);

	public void delete(Long id);
}
