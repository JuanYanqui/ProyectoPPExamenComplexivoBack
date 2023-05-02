package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IConvocatoriaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ConvocatoriaServiceImp extends GenericServiceImpl<Convocatorias,Long> implements IConvocatoriaService {
     @Autowired
    IConvocatoriaDao convocatoriaDao;
    @Override
    public CrudRepository<Convocatorias, Long> getDao() {
        return convocatoriaDao;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Convocatorias guardarDocumento(byte[] documento) {
        Convocatorias convocatorias=new Convocatorias();
        convocatorias.setDocumento_convocatoria(documento);
        return convocatoriaDao.save(convocatorias);
    }
}
