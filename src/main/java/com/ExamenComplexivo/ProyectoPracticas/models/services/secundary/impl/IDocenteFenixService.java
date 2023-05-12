package com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verdocentef;

import java.util.List;

public interface IDocenteFenixService {
    public List<verdocentef> findAll();

    public verdocentef findById(String cedula);

    List<String> obtenerNombresDocentes();

}
