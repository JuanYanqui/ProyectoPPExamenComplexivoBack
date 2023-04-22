package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.RepresentanteEmpresa;

import java.util.List;

public interface IRepresentanteEmpresaService {

	public List<RepresentanteEmpresa> findAll();

	RepresentanteEmpresa findByIdentificaion(String identificacion);

	public RepresentanteEmpresa save(RepresentanteEmpresa representanteempresa);

	public RepresentanteEmpresa findById(String id);

	public void delete(String id);
}
