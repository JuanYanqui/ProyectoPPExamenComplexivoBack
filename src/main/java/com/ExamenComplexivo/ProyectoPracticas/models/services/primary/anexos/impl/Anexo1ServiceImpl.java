package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo1Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo1Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Anexo1ServiceImpl extends GenericServiceImpl<Anexo1,Long> implements IAnexo1Service {
    @Autowired
    IAnexo1Dao anexo1Dao;
    @Override
    public CrudRepository<Anexo1, Long> getDao() {
        return anexo1Dao;
    }
}
