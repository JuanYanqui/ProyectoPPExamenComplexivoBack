package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo6Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo6;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_Anexo6Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Documento_Anexo6Imp extends GenericServiceImpl<Documento_Anexo6,Long> implements IDocumento_Anexo6Service {

    @Autowired
    IDocumento_Anexo6Dao documentoAnexo6Dao;


    @Override
    public CrudRepository<Documento_Anexo6, Long> getDao() {
        return documentoAnexo6Dao;
    }
}
