package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_AsigTutorAcaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_AsigTutorAcademico;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_AsigTutorAcaService;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class IDocumento_AsigTutorAcaImp extends GenericServiceImpl<Documento_AsigTutorAcademico,Long> implements IDocumento_AsigTutorAcaService {
    @Autowired
    IDocumento_AsigTutorAcaDao asigTutorAcaDao;
    @Override
    public CrudRepository<Documento_AsigTutorAcademico, Long> getDao() {
        return asigTutorAcaDao;
    }
}
