package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo3Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo3;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_Anexo3Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Documento_Anexo3Imp extends GenericServiceImpl<Documento_Anexo3,Long> implements IDocumento_Anexo3Service {
    @Autowired
    IDocumento_Anexo3Dao anexo3Dao;
    @Override
    public CrudRepository<Documento_Anexo3, Long> getDao() {
        return anexo3Dao;
    }
}
