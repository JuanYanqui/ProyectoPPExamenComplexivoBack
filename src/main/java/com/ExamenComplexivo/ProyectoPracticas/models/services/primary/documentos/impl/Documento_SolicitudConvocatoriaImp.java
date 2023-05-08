package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_ConvocatoriaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_SolicitudConvocatoriaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_SolicitudPracticasDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudConvocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_SolicitudConvocatoriaService;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_SolicitudPracticasService;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class Documento_SolicitudConvocatoriaImp extends GenericServiceImpl<Documento_SolicitudConvocatoria, Long> implements IDocumento_SolicitudConvocatoriaService {

    @Autowired
    IDocumento_SolicitudConvocatoriaDao documentoSolicitudConvocatoriaDao;
    @Override
    public CrudRepository<Documento_SolicitudConvocatoria, Long> getDao() {
        return documentoSolicitudConvocatoriaDao;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Documento_SolicitudConvocatoria guardarDocumento(byte[] documento) {
        Documento_SolicitudConvocatoria archivo=new Documento_SolicitudConvocatoria();
        archivo.setDocumento_solicitud_convocatoria(documento);
        return documentoSolicitudConvocatoriaDao.save(archivo);
    }
}
