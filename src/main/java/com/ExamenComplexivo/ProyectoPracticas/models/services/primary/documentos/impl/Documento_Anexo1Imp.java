package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo1Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_Anexo1Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Documento_Anexo1Imp extends GenericServiceImpl<Documento_Anexo1,Long> implements IDocumento_Anexo1Service {

    @Autowired
    IDocumento_Anexo1Dao documentoAnexo1Dao;
    @Override
    public CrudRepository<Documento_Anexo1, Long> getDao() {
        return documentoAnexo1Dao;
    }
}
