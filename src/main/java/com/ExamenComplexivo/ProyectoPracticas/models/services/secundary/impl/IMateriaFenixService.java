package com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.vermateriasf;

import java.util.List;

public interface IMateriaFenixService {

    public List<vermateriasf> findAll();

    public vermateriasf findById(Integer id_materia);

    List<String> obtenerMateriasPorCarrera(String nombreCarrera);
}
