package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.DocenteTutor;

import java.util.List;

public interface IDocenteTutorService {

	public List<DocenteTutor> findAll();

	DocenteTutor findByIdentificaion(String identificacion);

	public DocenteTutor save(DocenteTutor tutor);

	public DocenteTutor findById(String id);

	public void delete(String id);
}
