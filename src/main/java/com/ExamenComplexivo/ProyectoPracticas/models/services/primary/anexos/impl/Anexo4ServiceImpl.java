package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo4Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo4;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo4Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Anexo4ServiceImpl extends GenericServiceImpl<Anexo4,Long> implements IAnexo4Service {
    @Autowired
    IAnexo4Dao anexo4Dao;
    @Override
    public CrudRepository<Anexo4, Long> getDao() {
        return anexo4Dao;
    }
}
