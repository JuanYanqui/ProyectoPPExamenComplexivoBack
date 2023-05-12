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



}