package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_ConvenioDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_ConvenioService;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class Documento_ConvenioImp extends GenericServiceImpl<Documento_Convenio,Long> implements IDocumento_ConvenioService {
    @Autowired
    IDocumento_ConvenioDao documentoConvenioDao;
    @Override
    public CrudRepository<Documento_Convenio, Long> getDao() {
        return documentoConvenioDao;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Documento_Convenio guardarDocumento(byte[] documento) {
        Documento_Convenio archivo=new Documento_Convenio();
        archivo.setDocumentoConvenio(documento);
        return documentoConvenioDao.save(archivo);
    }
}
