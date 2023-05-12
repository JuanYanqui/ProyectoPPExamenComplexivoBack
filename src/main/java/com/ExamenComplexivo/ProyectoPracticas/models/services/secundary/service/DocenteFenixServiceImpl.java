package com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.service;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary.IverDocentesFDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verdocentef;
import com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl.IDocenteFenixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocenteFenixServiceImpl implements IDocenteFenixService {

    @Autowired
    private IverDocentesFDao iverDocentesFDao;

    @Override
    @Transactional(readOnly= true)
    public List<verdocentef> findAll() {
        // TODO Auto-generated method stub
        return (List<verdocentef>) iverDocentesFDao.findAll();
    }

    @Override
    @Transactional (readOnly= true)
    public verdocentef findById(String id) {
        // TODO Auto-generated method stub
        return iverDocentesFDao.findById(id).orElse(null);
    }

    public List<String> obtenerNombresDocentes() {
        return iverDocentesFDao.findAllNombresDocentes();
    }
}
