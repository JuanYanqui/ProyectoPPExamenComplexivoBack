package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo8Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo8;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_Anexo8Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Documento_Anexo8Imp extends GenericServiceImpl<Documento_Anexo8,Long> implements IDocumento_Anexo8Service {
    @Autowired
    IDocumento_Anexo8Dao documentoAnexo8Dao;
    @Override
    public CrudRepository<Documento_Anexo8, Long> getDao() {
        return documentoAnexo8Dao;
    }
}
