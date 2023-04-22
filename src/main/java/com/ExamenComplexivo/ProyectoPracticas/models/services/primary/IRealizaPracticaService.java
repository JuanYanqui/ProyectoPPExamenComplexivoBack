package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.RealizaPractica;

import java.util.List;

public interface IRealizaPracticaService {

	public List<RealizaPractica> findAll();
	public List<RealizaPractica> findbyconv(Long idconv);

	public RealizaPractica save(RealizaPractica realiza);

	public RealizaPractica findById(Long id);

	public void delete(Long id);
}
