package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo5Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo5;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_Anexo5Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Documento_Anexo5Imp extends GenericServiceImpl<Documento_Anexo5,Long> implements IDocumento_Anexo5Service {
    @Autowired
    IDocumento_Anexo5Dao documentoAnexo5Dao;
    @Override
    public CrudRepository<Documento_Anexo5, Long> getDao() {
        return documentoAnexo5Dao;
    }
}
