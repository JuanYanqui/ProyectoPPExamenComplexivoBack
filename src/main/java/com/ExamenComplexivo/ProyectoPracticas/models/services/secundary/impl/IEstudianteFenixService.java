package com.ExamenComplexivo.ProyectoPracticas.models.services.secundary.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.secundary.verestudiantef;

import java.util.List;

public interface IEstudianteFenixService {
    public List<verestudiantef> findAll();

    public verestudiantef findById(String cedula);
}
