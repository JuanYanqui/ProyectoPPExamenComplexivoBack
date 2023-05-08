package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_ConvocatoriaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convocatoria;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_SolicitudPracticas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_ConvocatoriaService;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class Documento_ConvocatoriaImp extends GenericServiceImpl <Documento_Convocatoria, Long> implements IDocumento_ConvocatoriaService {


    @Autowired
    IDocumento_ConvocatoriaDao documentoConvocatoriaDao;
    @Override
    public CrudRepository<Documento_Convocatoria, Long> getDao() {
        return documentoConvocatoriaDao;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Documento_Convocatoria guardarDocumento(byte[] documento) {
        Documento_Convocatoria archivo=new Documento_Convocatoria();
        archivo.setDocumento_convocatoria(documento);
        return documentoConvocatoriaDao.save(archivo);
    }
}
