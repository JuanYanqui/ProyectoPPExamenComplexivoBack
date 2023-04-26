package com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.service;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary.IVerpersonafDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verpersonaf;
import com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl.IDocenteFenixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IDocenteFenixServiceImpl implements IDocenteFenixService {

    @Autowired
    private IVerpersonafDao verpersonafDao;

    @Override
    @Transactional(readOnly= true)
    public List<verpersonaf> findAll() {
        // TODO Auto-generated method stub
        return (List<verpersonaf>) verpersonafDao.findAll();
    }

    @Override
    @Transactional (readOnly= true)
    public verpersonaf findById(String id) {
        // TODO Auto-generated method stub
        return verpersonafDao.findById(id).orElse(null);
    }
}
