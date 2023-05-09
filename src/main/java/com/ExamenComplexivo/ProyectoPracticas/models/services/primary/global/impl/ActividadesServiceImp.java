package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IActividadesDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Actividades;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IActividadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadesServiceImp extends GenericServiceImpl<Actividades,Long> implements IActividadesService {
    @Autowired
    IActividadesDao actividadesDao;
    @Override
    public CrudRepository<Actividades, Long> getDao() {
        return actividadesDao;
    }

    public List<Actividades> obtenerActividadesPorConvocatoria(Long convocatoriaId) {
        return actividadesDao.findActividadesByConvocatoriaId(convocatoriaId);
    }
}
