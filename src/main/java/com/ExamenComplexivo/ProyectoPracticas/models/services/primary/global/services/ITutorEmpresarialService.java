package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Tutor_Empresarial;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;

import java.util.List;

public interface ITutorEmpresarialService extends IGenericService<Tutor_Empresarial,Long> {


    Tutor_Empresarial findByUsuarioId(Long idUsuario);

    void actualizarTutorEmpresarial(Long idTutorEmpresarial);
}
