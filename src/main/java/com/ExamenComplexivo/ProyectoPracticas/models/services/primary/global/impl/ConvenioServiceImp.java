package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IConvenioDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConvenioServiceImp extends GenericServiceImpl<Convenio,Long> implements IConvenioService {
   @Autowired
    IConvenioDao convenioDao;

    @Override
    public CrudRepository<Convenio, Long> getDao() {
        return convenioDao;
    }
}
