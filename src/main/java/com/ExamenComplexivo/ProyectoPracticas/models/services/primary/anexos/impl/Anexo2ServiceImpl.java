package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo2Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo2;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo2Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Anexo2ServiceImpl extends GenericServiceImpl<Anexo2,Long> implements IAnexo2Service {
    @Autowired
    IAnexo2Dao anexo2Dao;
    @Override
    public CrudRepository<Anexo2, Long> getDao() {
        return anexo2Dao;
    }
}
