package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatoria;

import java.util.List;

public interface IConvocatoriaService {

	public List<Convocatoria> findAll();

	public Convocatoria save(Convocatoria convocatoria);

	public Convocatoria findById(Long id);

	public void delete(Long id);
}
