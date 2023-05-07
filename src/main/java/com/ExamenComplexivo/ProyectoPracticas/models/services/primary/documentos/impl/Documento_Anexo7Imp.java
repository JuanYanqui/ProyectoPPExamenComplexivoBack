package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo7Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo7;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_Anexo7Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Documento_Anexo7Imp  extends GenericServiceImpl<Documento_Anexo7,Long> implements IDocumento_Anexo7Service {
    @Autowired
    IDocumento_Anexo7Dao documentoAnexo7Dao;
    @Override
    public CrudRepository<Documento_Anexo7, Long> getDao() {
        return documentoAnexo7Dao;
    }
}
