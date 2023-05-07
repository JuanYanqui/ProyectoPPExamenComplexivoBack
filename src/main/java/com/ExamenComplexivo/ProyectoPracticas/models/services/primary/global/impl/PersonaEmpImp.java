package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IPersonaEmpDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Personas_empresa;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IPersonaEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaEmpImp extends GenericServiceImpl<Personas_empresa,Long> implements IPersonaEmpService {
    @Autowired
    IPersonaEmpDao persona_empDao;
    @Override
    public CrudRepository<Personas_empresa, Long> getDao() {
        return persona_empDao;
    }


    @Override
    public Personas_empresa findbyCedula(String cedula) {return persona_empDao.findByCedula(cedula);
}

    @Override
    public Personas_empresa findbyCorreo(String correo) {
        return persona_empDao.findByCorreo(correo);
    }
}
