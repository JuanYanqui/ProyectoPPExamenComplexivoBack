package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.ISolicitudConvocatoriaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.ISolicitudPracticasDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.ISolicitudConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class SolicitudConvocatoriaServiceImpl extends GenericServiceImpl<Solicitud_Convocatoria,Long> implements ISolicitudConvocatoriaService {
    @Autowired
    ISolicitudConvocatoriaDao solicitudConvocatoriaDao;

    @Override
    public CrudRepository<Solicitud_Convocatoria, Long> getDao() {
        return solicitudConvocatoriaDao;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Solicitud_Convocatoria guardarDocumento(byte[] documento) {
        Solicitud_Convocatoria solicitud=new Solicitud_Convocatoria();
        return solicitudConvocatoriaDao.save(solicitud);
    }

    public List<Solicitud_Convocatoria> findByCheckResponsableAndIdSolicitudPracticas(Long idSolicitudPracticas) {
        return solicitudConvocatoriaDao.findByCheckResponsableAndIdSolicitudPracticas(idSolicitudPracticas);
    }


    public List<Solicitud_Convocatoria> getSolicitudesPorConvocatoria(Long convocatoriaId) {
        return solicitudConvocatoriaDao.findByConvocatoriaId(convocatoriaId);
    }

    public List<Solicitud_Convocatoria> getSolicitudesPorConvocatoriatrue(Long convocatoriaId) {
        return solicitudConvocatoriaDao.findByConvocatoriaIdtrue(convocatoriaId);
    }

    public List<Solicitud_Convocatoria> getSolicitudesPorConvocatoriatruepractica(Long convocatoriaId) {
        return solicitudConvocatoriaDao.findByConvocatoriaIdtrueprueba(convocatoriaId);
    }


    public int getCountByConvocatoriaAndEstudiante(Long convocatoriaId, Long estudiantePracticasId) {
        return solicitudConvocatoriaDao.getCountByConvocatoriaAndEstudiante(convocatoriaId, estudiantePracticasId);
    }

    public List<Solicitud_Convocatoria> findByConvocatoriasDirector(Long convocatoriaId) {
        return solicitudConvocatoriaDao.findByConvocatoriasDirector(convocatoriaId);
    }

    public List<Solicitud_Convocatoria> findByConvocatoriasDirectorFalse(Long convocatoriaId) {
        return solicitudConvocatoriaDao.findByConvocatoriasDirectorFalse(convocatoriaId);
    }
    public List<Solicitud_Convocatoria> findByConvocatoriasTutor(Long convocatoriaId) {
        return solicitudConvocatoriaDao.findByConvocatoriasTutor(convocatoriaId);
    }

    public List<Solicitud_Convocatoria> findByConvocatoriasTutorFalse(Long convocatoriaId) {
        return solicitudConvocatoriaDao.findByConvocatoriasTutorFalse(convocatoriaId);
    }

    public List<Solicitud_Convocatoria> findByAnexo1(Long convocatoriaId) {
        return solicitudConvocatoriaDao.findByAnexo1(convocatoriaId);
    }

    public List<Solicitud_Convocatoria> findByAnexo5(Long convocatoriaId) {
        return solicitudConvocatoriaDao.findByAnexo5(convocatoriaId);
    }

    public List<Solicitud_Convocatoria> findByAnexo7(Long convocatoriaId) {
        return solicitudConvocatoriaDao.findByAnexo7(convocatoriaId);
    }

        public List<Solicitud_Convocatoria> findSolicitudConvocatoriaPorEstudianteSinCancelar(String cedula) {
        return solicitudConvocatoriaDao.findSolicitudConvocatoriaPorEstudianteSinCancelar(cedula);
    }

    public List<Solicitud_Convocatoria> findSolicitudConvocatoriaPorEstudianteCancelado(String cedula) {
        return solicitudConvocatoriaDao.findSolicitudConvocatoriaPorEstudianteCancelado(cedula);
    }
}
