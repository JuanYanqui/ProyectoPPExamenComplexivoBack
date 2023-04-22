package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Discapacidad;

import java.util.List;

public interface IDiscapacidadService {

	public List<Discapacidad> findAll();

	public Discapacidad save(Discapacidad discapacidad);

	public Discapacidad findById(Long id);

	public void delete(Long id);
}
