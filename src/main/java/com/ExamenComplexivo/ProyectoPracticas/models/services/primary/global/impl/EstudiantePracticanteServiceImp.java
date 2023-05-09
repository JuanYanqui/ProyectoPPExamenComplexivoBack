package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IEstudiantePracticanteDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Estudiante_Practicante;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IEstudiantePracticanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiantePracticanteServiceImp extends GenericServiceImpl<Estudiante_Practicante,Long> implements IEstudiantePracticanteService {
    @Autowired
    IEstudiantePracticanteDao estudiantePracticanteDao;
    @Override
    public CrudRepository<Estudiante_Practicante, Long> getDao() {
        return estudiantePracticanteDao;
    }

    public List<Estudiante_Practicante> findByCedula(String cedula) {
        return estudiantePracticanteDao.findByCedula(cedula);
    }

    public Long findIdByCedula(String cedula) {
        return estudiantePracticanteDao.findIdByCedula(cedula);
    }
}
