package com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verCarreras;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

import java.util.List;

public interface IverCarreraService{
    public List<verCarreras> findAll();

    public verCarreras findById(Integer id);

}
