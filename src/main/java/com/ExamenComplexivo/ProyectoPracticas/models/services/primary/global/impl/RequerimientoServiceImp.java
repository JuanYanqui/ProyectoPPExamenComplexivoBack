package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IRequerimientosDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Requerimientos;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IRequerimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RequerimientoServiceImp extends GenericServiceImpl<Requerimientos,Long> implements IRequerimientoService {
    @Autowired
    IRequerimientosDao requerimientosDao;
    @Override
    public CrudRepository<Requerimientos, Long> getDao() {
        return requerimientosDao;
    }
}
