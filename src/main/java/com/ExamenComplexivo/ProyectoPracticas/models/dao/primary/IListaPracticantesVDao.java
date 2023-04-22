package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.lista_practicantes_view;
import org.springframework.data.repository.CrudRepository;

public interface IListaPracticantesVDao extends CrudRepository<lista_practicantes_view, Long> {

}