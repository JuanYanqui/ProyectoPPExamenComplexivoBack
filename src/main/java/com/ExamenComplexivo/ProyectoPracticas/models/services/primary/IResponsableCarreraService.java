package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.ResponsableCarrera;

import java.util.List;

public interface IResponsableCarreraService {

	public List<ResponsableCarrera> findAll();

	ResponsableCarrera findByIdentificaion(String identificacion);

	public ResponsableCarrera save(ResponsableCarrera representante);

	public ResponsableCarrera findById(String id);

	public void delete(String id);
}
