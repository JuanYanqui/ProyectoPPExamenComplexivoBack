package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IDetalleConvenioDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Detalle_Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IDetalleConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleConvenioServiceImp extends GenericServiceImpl<Detalle_Convenio,Long> implements IDetalleConvenioService {
    @Autowired
    IDetalleConvenioDao detalleConvenioDao;
    @Override
    public CrudRepository<Detalle_Convenio, Long> getDao() {
        return detalleConvenioDao;
    }

    public List<Detalle_Convenio> findByEmpresaId(Long idEmpresa) {
        return detalleConvenioDao.findByEmpresaId(idEmpresa);
    }

}
