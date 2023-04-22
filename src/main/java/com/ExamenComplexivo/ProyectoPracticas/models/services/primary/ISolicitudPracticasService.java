package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.SolicitudPracticas;

import java.util.List;

public interface ISolicitudPracticasService {

	public List<SolicitudPracticas> findAll();

	public SolicitudPracticas save(SolicitudPracticas solicitud);

	public SolicitudPracticas findById(Long id);

	public void delete(Long id);
}
