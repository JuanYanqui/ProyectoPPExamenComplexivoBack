package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Coordinador;

import java.util.List;

public interface ICoordinadorService {

	public List<Coordinador> findAll();

	public Coordinador save(Coordinador coordinador);

	public Coordinador findById(Long id);

	public void delete(Long id);
}
