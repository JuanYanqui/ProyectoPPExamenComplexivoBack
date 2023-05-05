package com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verCarreras;


import java.util.List;

public interface IverCarreraService{
    public List<verCarreras> findAll();

    public verCarreras findById(Integer id);

    List<String> obtenerNombresCarreras();

}
