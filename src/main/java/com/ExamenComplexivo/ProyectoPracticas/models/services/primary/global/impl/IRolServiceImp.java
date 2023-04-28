package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IRolDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Rol;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class IRolServiceImp extends GenericServiceImpl<Rol,Long> implements IRolService {
   @Autowired
    IRolDao rolDao;
    @Override
    public CrudRepository<Rol, Long> getDao() {
        return rolDao;
    }
}
