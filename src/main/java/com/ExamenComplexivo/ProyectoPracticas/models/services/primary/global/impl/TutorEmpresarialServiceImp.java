package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.ITutorEmpresarialDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Tutor_Empresarial;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.ITutorEmpresarialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TutorEmpresarialServiceImp extends GenericServiceImpl<Tutor_Empresarial,Long> implements ITutorEmpresarialService {
    @Autowired
    ITutorEmpresarialDao tutorEmpresarialDao;
    @Override
    public CrudRepository<Tutor_Empresarial, Long> getDao() {
        return tutorEmpresarialDao;
    }
}