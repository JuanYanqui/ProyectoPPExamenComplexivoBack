package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.ISolicitudPracticasDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.ISolicitudPracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class SolicitudPracticasImp extends GenericServiceImpl<Solicitud_Practicas,Long> implements ISolicitudPracticaService {
    @Autowired
    ISolicitudPracticasDao solicitudPracticasDao;
     @Override
    public CrudRepository<Solicitud_Practicas, Long> getDao() {
        return solicitudPracticasDao;
    }
}
