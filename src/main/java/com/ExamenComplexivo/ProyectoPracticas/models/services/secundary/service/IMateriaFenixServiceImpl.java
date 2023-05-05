package com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.service;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary.IVerpersonafDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary.IverMateriasFDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.vermateriasf;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verpersonaf;
import com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl.IMateriaFenixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IMateriaFenixServiceImpl implements IMateriaFenixService {

    @Autowired
    private IverMateriasFDao verMateriasFDao;

    @Override
    @Transactional(readOnly= true)
    public List<vermateriasf> findAll() {
        // TODO Auto-generated method stub
        return (List<vermateriasf>) verMateriasFDao.findAll();
    }

    @Override
    @Transactional (readOnly= true)
    public vermateriasf findById(Integer id) {
        // TODO Auto-generated method stub
        return verMateriasFDao.findById(id).orElse(null);
    }


    public List<String> obtenerMateriasPorCarrera(String nombreCarrera) {
        return verMateriasFDao.obtenerMateriasPorCarrera(nombreCarrera);
    }
}
