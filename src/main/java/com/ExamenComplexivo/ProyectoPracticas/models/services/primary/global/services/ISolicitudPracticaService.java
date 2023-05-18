package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

import java.util.List;

public interface ISolicitudPracticaService extends IGenericService<Solicitud_Practicas,Long> {

    List<Solicitud_Practicas> findByEstadoActividadTrue();
    List<Solicitud_Practicas> buscarPorEstadoSolicitud(boolean estado);

    List<Solicitud_Practicas> buscarPorEmpresa(Long idempresa);

    Long findDocumentoIdBySolicitudId(Long id);

    List<Usuario> obtenerNombresTutores(Long idempresa);

    List<Solicitud_Practicas> findByEstadoSolicitudPorcarrera(String carrera);

    List<Solicitud_Practicas> findByEstadoSolicitudPorcarreraSolicitudaprobada(String carrera);

    List<Solicitud_Practicas> findByEstadoActividadTruePorResponsablePPP(Long idresponsableppp);

    List<Solicitud_Practicas> findBySolicitudpracticasCheckResponsable(Long carrera);

    List<Solicitud_Practicas> buscarsoliporempresa(Long idempresa);

    List<Object[]> buscarsolportutor(Long idUsuario);

    List<Object[]> buscarsolportutoraceptadas(Long idUsuario);

}