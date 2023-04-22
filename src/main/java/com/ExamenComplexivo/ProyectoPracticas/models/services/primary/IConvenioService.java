package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;

import java.util.List;

public interface IConvenioService {

	public List<Convenio> findAll();

	public Convenio save(Convenio convenio);

	public Convenio findById(Long id);

	public void delete(Long id);
}
