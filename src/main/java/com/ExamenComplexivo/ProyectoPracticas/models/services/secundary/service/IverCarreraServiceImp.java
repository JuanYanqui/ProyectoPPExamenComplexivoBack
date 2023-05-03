package com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.service;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.secundary.IverCarrerasfDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verCarreras;
import com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl.IverCarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class IverCarreraServiceImp implements IverCarreraService {

    @Autowired
    IverCarrerasfDao carrerasfDao;
    @Override
    @Transactional(readOnly= true)
    public List<verCarreras> findAll() {
        return (List<verCarreras>) carrerasfDao.findAll();
    }

    @Override
    @Transactional(readOnly= true)
    public verCarreras findById(Integer id) {
        return carrerasfDao.findById(id).orElse(null);
    }

    public List<String> obtenerNombresCarreras() {
        return carrerasfDao.findAllNombres();
    }
}
