package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IPracticaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo2;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo3;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IPracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PracticaServiceImp extends GenericServiceImpl<Practica,Long> implements IPracticaService {
    @Autowired
    IPracticaDao practicaDao;
    @Override
    public CrudRepository<Practica, Long> getDao() {
        return practicaDao;
    }

    public List<Practica> getPracticasAprobadas(Long idempresa) {
        return practicaDao.getPracticasAprobadas(idempresa);
    }

    public List<Practica> getPracticasByConvocatoriaId(Long convocatoriaId) {
        return practicaDao.getPracticasByConvocatoriaId(convocatoriaId);
    }

    @Override
    @Transactional
    public void actualizarDocumentoAsigTutorAc(Long idDocumentoAsigTutorAcademico, Long idPractica) {
        practicaDao.actualizarDocumentoAsigTutorAc(idDocumentoAsigTutorAcademico, idPractica);

    }
    public List<Practica> getPracticasBySolicitudPracticasId(Long solicitudpracticasId) {
        return practicaDao.getPracticasBySolicitudPracticasId(solicitudpracticasId);
    }

    public List<Practica> getPracticasByAcademico(String cedula) {
        return practicaDao.getPracticasByAcademico(cedula);
    }

    public List<Practica> getPracticasByDocumentoAnexo(Long convocatoriaid, Long idusuario) {
        return practicaDao.getPracticasByDocumentoAnexo(convocatoriaid, idusuario);
    }
    public List<Practica> getPracticasByEstudiante(String cedula) {
        return practicaDao.getPracticasByEstudiante(cedula);
    }

    public List<Practica> getPracticasByEstudianteAnexo3(String cedula) {
        return practicaDao.getPracticasByEstudianteAnexo3(cedula);
    }


    public List<Anexo1> getPracticasByCarrera(String carrera) {
        return practicaDao.findByCarreraRecibeAnexo(carrera);
    }
    public List<Anexo2> getPracticasByCarrera2(String carrera) {
        return practicaDao.findByCarreraRecibeAnexo2(carrera);
    }

    public List<Anexo3> getPracticasByCarrera3(String carrera) {
        return practicaDao.findByCarreraRecibeAnexo3(carrera);
    }

    public List<Practica> getPracticasByDocumentoAnexo5(Long convocatoriaid, Long idusuario) {
        return practicaDao.getPracticasByDocumentoAnexo5(convocatoriaid, idusuario);
    }

    public List<Practica> getPracticasByEstudianteAnexo6(String cedula) {
        return practicaDao.getPracticasByEstudianteAnexo6(cedula);
    }

}
