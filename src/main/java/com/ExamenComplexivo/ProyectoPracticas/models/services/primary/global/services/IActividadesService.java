package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IActividadesDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Actividades;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IActividadesService extends IGenericService<Actividades,Long> {


    List<Actividades> obtenerActividadesPorConvocatoria(Long convocatoriaId);
}
