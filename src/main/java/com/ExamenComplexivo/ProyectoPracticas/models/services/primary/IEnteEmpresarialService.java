package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.EnteEmpresarial;

import java.util.List;

public interface IEnteEmpresarialService {

	public List<EnteEmpresarial> findAll();

	public EnteEmpresarial save(EnteEmpresarial enteEmp);

	public EnteEmpresarial findById(Long id);

	public void delete(Long id);
}
