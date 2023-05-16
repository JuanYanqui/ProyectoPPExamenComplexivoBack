package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_Anexo2Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_Anexo2;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_Anexo2Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Documento_Anexo2Imp  extends GenericServiceImpl<Documento_Anexo2,Long> implements IDocumento_Anexo2Service {
    @Autowired
    IDocumento_Anexo2Dao anexo2Dao;
    @Override
    public CrudRepository<Documento_Anexo2, Long> getDao() {
        return anexo2Dao;
    }
}
