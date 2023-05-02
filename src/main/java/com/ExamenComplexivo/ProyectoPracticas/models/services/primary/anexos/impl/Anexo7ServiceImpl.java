package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.impl;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo7p1_EvaluaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo7;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo7Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Anexo7ServiceImpl extends GenericServiceImpl<Anexo7,Long> implements IAnexo7Service {
    @Autowired
    IAnexo7p1_EvaluaDao anexo7Dao;

    @Override
    public CrudRepository<Anexo7, Long> getDao() {
        return anexo7Dao;
    }
}
