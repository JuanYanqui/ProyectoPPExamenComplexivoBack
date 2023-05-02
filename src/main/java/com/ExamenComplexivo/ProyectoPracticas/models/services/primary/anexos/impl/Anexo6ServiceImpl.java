package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.impl;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo6_DetallePracticaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo6;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo6Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import java.io.Serial;

@Service
public class Anexo6ServiceImpl extends GenericServiceImpl<Anexo6,Long> implements IAnexo6Service {
    @Autowired
    IAnexo6_DetallePracticaDao anexo6Dao;

    @Override
    public CrudRepository<Anexo6, Long> getDao() {
        return anexo6Dao;
    }
}
