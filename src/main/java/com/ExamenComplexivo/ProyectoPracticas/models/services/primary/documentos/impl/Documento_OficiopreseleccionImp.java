package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.documentos.IDocumento_OficioPreseleccionDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.documentos.Documento_OficioPreseleccion;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.documentos.service.IDocumento_OficioPreSeleccionService;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Documento_OficiopreseleccionImp extends GenericServiceImpl<Documento_OficioPreseleccion,Long> implements IDocumento_OficioPreSeleccionService {
    @Autowired
    IDocumento_OficioPreseleccionDao oficioPreseleccionDao;
    @Override
    public CrudRepository<Documento_OficioPreseleccion, Long> getDao() {
        return oficioPreseleccionDao;
    }
}
