package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo3Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo3;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo3Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Anexo3ServiceImpl extends GenericServiceImpl<Anexo3,Long> implements IAnexo3Service {
    @Autowired
    IAnexo3Dao anexo3Dao;
    @Override
    public CrudRepository<Anexo3, Long> getDao() {
        return anexo3Dao;
    }
}
