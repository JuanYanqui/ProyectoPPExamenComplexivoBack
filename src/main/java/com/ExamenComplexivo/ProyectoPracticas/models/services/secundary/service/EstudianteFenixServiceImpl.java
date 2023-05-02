package com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.service;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary.IverEstudianteFDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verestudiantef;
import com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl.IEstudianteFenixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EstudianteFenixServiceImpl implements IEstudianteFenixService {
    @Autowired
    private IverEstudianteFDao iverEstudianteFDao;

    @Override
    @Transactional(readOnly= true)
    public List<verestudiantef> findAll() {
        // TODO Auto-generated method stub
        return (List<verestudiantef>) iverEstudianteFDao.findAll();
    }

    @Override
    @Transactional (readOnly= true)
    public verestudiantef findById(String id) {
        // TODO Auto-generated method stub
        return iverEstudianteFDao.findById(id).orElse(null);
    }
}
