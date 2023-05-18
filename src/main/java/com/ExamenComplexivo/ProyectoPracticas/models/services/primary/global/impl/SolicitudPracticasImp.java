package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.ISolicitudPracticasDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.ISolicitudPracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class SolicitudPracticasImp extends GenericServiceImpl<Solicitud_Practicas,Long> implements ISolicitudPracticaService {
    @Autowired
    ISolicitudPracticasDao solicitudPracticasDao;
     @Override
    public CrudRepository<Solicitud_Practicas, Long> getDao() {
        return solicitudPracticasDao;
    }

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Solicitud_Practicas> findByEstadoActividadTrue() {
        return solicitudPracticasDao.findByEstadoActividadTrue();

    }
    public List<Solicitud_Practicas> buscarPorEstadoSolicitud(boolean estado) {
        return solicitudPracticasDao.findByEstadoSolicitud(estado);
    }

    @Override
    public List<Solicitud_Practicas> buscarPorEmpresa(Long idempresa) {
        return solicitudPracticasDao.findByEsta(idempresa);
    }

    @Override
    public Long findDocumentoIdBySolicitudId(Long id) {
        return solicitudPracticasDao.findDocumentoIdBySolicitudId(id);
    }
    public List<Usuario> obtenerNombresTutores(Long idempresa) {
        return solicitudPracticasDao.findAllNombresTutores(idempresa);
    }

    public List<Solicitud_Practicas> findByEstadoSolicitudPorcarrera(String empresa) {
        return solicitudPracticasDao.findByEstadoSolicitudPorcarrera(empresa);
    }

    public List<Solicitud_Practicas> findByEstadoSolicitudPorcarreraSolicitudaprobada(String empresa) {
        return solicitudPracticasDao.findByEstadoSolicitudPorcarreraSolicitudaprobada(empresa);
    }

    public List<Solicitud_Practicas> findByEstadoActividadTruePorResponsablePPP(Long idresponsableppp) {
        return solicitudPracticasDao.findByEstadoActividadTruePorResponsablePPP(idresponsableppp);
    }

    public List<Solicitud_Practicas> findBySolicitudpracticasCheckResponsable(Long empresa) {
        return solicitudPracticasDao.findBySolicitudpracticasCheckResponsable(empresa);
    }
    public List<Solicitud_Practicas> buscarsoliporempresa(Long idempresa) {
        return solicitudPracticasDao.buscarsoliporempresa(idempresa);
    }


    public List<Object[]> buscarsolportutor(Long idUsuario) {
        return solicitudPracticasDao.buscarsolportutor(idUsuario);
    }


    public List<Object[]> buscarsolportutoraceptadas(Long idUsuario) {
        return solicitudPracticasDao.buscarsolportutoraceptadas(idUsuario);
    }
}
