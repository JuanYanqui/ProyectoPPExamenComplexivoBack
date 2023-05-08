package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_ConvenioDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_SolicitudPracticasDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_SolicitudPracticasService;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
public class Documento_SolicitudPracticasImp extends GenericServiceImpl<Documento_SolicitudPracticas, Long> implements IDocumento_SolicitudPracticasService {

    @Autowired
    IDocumento_SolicitudPracticasDao documentoSolicitudPracticasDao;
    @Override
    public CrudRepository<Documento_SolicitudPracticas, Long> getDao() {
        return documentoSolicitudPracticasDao;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Documento_SolicitudPracticas guardarDocumento(byte[] documento) {
        Documento_SolicitudPracticas archivo=new Documento_SolicitudPracticas();
        archivo.setDocumento_solicitud_practicas(documento);
        return documentoSolicitudPracticasDao.save(archivo);
    }


}
