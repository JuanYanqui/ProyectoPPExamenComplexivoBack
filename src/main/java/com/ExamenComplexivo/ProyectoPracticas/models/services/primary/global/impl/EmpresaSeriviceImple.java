package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IEmpresaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Empresa;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IEmpresaService;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaSeriviceImple extends GenericServiceImpl<Empresa,Long> implements IEmpresaService {
   @Autowired
    IEmpresaDao empresaDao;
    @Override
    public CrudRepository<Empresa, Long> getDao() {
        return empresaDao;
    }
}
