package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.verDocentes;

import java.util.List;

public interface IverDocenteService {

	public List<verDocentes> findAll();

	public verDocentes findById(Long id_persona);
}
