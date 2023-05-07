package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo4Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo4;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_Anexo4Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Documento_Anexo4Imp extends GenericServiceImpl<Documento_Anexo4,Long> implements IDocumento_Anexo4Service {
    @Autowired
    IDocumento_Anexo4Dao documentoAnexo4Dao;
    @Override
    public CrudRepository<Documento_Anexo4, Long> getDao() {
        return documentoAnexo4Dao;
    }
}
