package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IPracticaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.*;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_AsigTutorAcademico;
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
    public Boolean getPracticasByEstadoxUsuario(Long idUsuario) {
        return practicaDao.getPracticasByEstadoxUsuario(idUsuario);
    }

    public List<Convocatorias> getPracticasByAcademico(String cedula) {
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


    public List<Anexo1> getPracticasByCarrera(Long idconvo) {
        return practicaDao.findByCarreraRecibeAnexo(idconvo);
    }
    public List<Anexo2> getPracticasByCarrera2(Long idconvo) {
        return practicaDao.findByCarreraRecibeAnexo2(idconvo);
    }

    public List<Anexo3> getPracticasByCarrera3(Long idconvo) {
        return practicaDao.findByCarreraRecibeAnexo3(idconvo);
    }

    public List<Practica> getPracticasByCarrera4(Long idconvo) {
        return practicaDao.findByCarreraRecibeAnexo4(idconvo);
    }

    public List<Practica> getPracticasByDocumentoAnexo5(Long convocatoriaid, Long idusuario) {
        return practicaDao.getPracticasByDocumentoAnexo5(convocatoriaid, idusuario);
    }

    public List<Practica> getPracticasByEstudianteAnexo6(String cedula) {
        return practicaDao.getPracticasByEstudianteAnexo6(cedula);
    }

    public List<Convocatorias> getPracticasByEmpresarialAnexo7(Long idempresa) {
        return practicaDao.getPracticasByEmpresarialAnexo7(idempresa);
    }

    public List<Practica> getPracticasBylistarAnexo7(Long tutor) {
        return practicaDao.getPracticasBylistarAnexo7(tutor);
    }

    public List<Practica> getPracticasByEstudianteAnexo8(String cedula) {
        return practicaDao.getPracticasByEstudianteAnexo8(cedula);
    }


    public Long getPracticasByConvocatoriaIdAnexo1(Long solicitudpracticasId) {
        return practicaDao.getPracticasByConvocatoriaIdAnexo1(solicitudpracticasId);
    }

    public List<Anexo5> getPracticasByCarrera5(Long idconvo) {
        return practicaDao.findByCarreraRecibeAnexo5(idconvo);
    }

    public List<Anexo6> getPracticasByCarrera6(Long idconvo) {
        return practicaDao.findByCarreraRecibeAnexo6(idconvo);
    }

    public List<Anexo7> getPracticasByCarrera7(Long idconvo) {
        return practicaDao.findByCarreraRecibeAnexo7(idconvo);
    }

    public List<Anexo8> getPracticasByCarrera8(Long idconvo) {
        return practicaDao.findByCarreraRecibeAnexo8(idconvo);
    }

    public Boolean getConvocatoriaLanzada(String nombre_carrera){
        return practicaDao.getConvocatoriaLanzada(nombre_carrera);
    }
    @Override
    public List<Object[]> getConvocatoriaDisp(String nombre_carrera) {
        return practicaDao.getConvocatoriaDisp(nombre_carrera);
}
    public List<Anexo1> findByDocumentoA1(Long idpractica) {
        return practicaDao.findByDocumentoA1(idpractica);
    }

    public List<Convocatorias> findByPracticaAnexo1(String cedula) {
        return practicaDao.findByPracticaAnexo1(cedula);
    }

    public List<Convocatorias> findByPracticaAnexoParaAcademixoRecibe(String cedula) {
        return practicaDao.findByPracticaAnexoParaAcademixoRecibe(cedula);
    }

    public List<Convocatorias> findByPracticaAnexoParaResponsableFinal(String cedula) {
        return practicaDao.findByPracticaAnexoParaResponsableFinal(cedula);
    }

    public List<Anexo5> findByDocumentoA5(Long convocatoria) {
        return practicaDao.findByDocumentoA5(convocatoria);
    }

    public List<Anexo6> findByDocumentoA6(Long convocatoria) {
        return practicaDao.findByDocumentoA6(convocatoria);
    }

    public List<Anexo6> findByParaAcademicoDocumentoA6(Long convocatoria) {
        return practicaDao.findByParaAcademicoDocumentoA6(convocatoria);
    }

    public List<Anexo7> findByParaEmpresarialDocumentoA7(Long convocatoria) {
        return practicaDao.findByParaEmpresarialDocumentoA7(convocatoria);
    }

    public List<Anexo8> findByParaAcademicoDocumentoA8(Long convocatoria) {
        return practicaDao.findByParaAcademicoDocumentoA8(convocatoria);
    }

    public List<Anexo8> findByParaEmpresarialDocumentoA8(Long convocatoria) {
        return practicaDao.findByParaEmpresarialDocumentoA8(convocatoria);
    }
}
