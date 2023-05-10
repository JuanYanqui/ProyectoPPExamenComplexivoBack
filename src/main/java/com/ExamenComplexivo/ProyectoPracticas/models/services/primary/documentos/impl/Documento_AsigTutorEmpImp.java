package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_AsigTutorEmpDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_AsigTutorEmpresarial;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_AsigTutorEmpServices;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Documento_AsigTutorEmpImp extends GenericServiceImpl<Documento_AsigTutorEmpresarial,Long> implements IDocumento_AsigTutorEmpServices {
    @Autowired
    IDocumento_AsigTutorEmpDao documentoAsigTutorEmpDao;
    @Override
    public CrudRepository<Documento_AsigTutorEmpresarial, Long> getDao() {
        return documentoAsigTutorEmpDao;
    }
}
