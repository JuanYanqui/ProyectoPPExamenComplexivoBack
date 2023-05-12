package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IPracticaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Practica;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IPracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticaServiceImp extends GenericServiceImpl<Practica,Long> implements IPracticaService {
    @Autowired
    IPracticaDao practicaDao;
    @Override
    public CrudRepository<Practica, Long> getDao() {
        return practicaDao;
    }

    public List<Practica> getPracticasAprobadas() {
        return practicaDao.getPracticasAprobadas();
    }

    public List<Practica> getPracticasByConvocatoriaId(Long convocatoriaId) {
        return practicaDao.getPracticasByConvocatoriaId(convocatoriaId);
    }

}
