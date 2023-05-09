package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IResponsable_PPPDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Responsable_PPP;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsablePPPServiceImp extends GenericServiceImpl<Responsable_PPP,Long> implements IResponsableService {
    @Autowired
    IResponsable_PPPDao responsablePppDao;
    @Override
    public CrudRepository<Responsable_PPP, Long> getDao() {
        return responsablePppDao;
    }

    public List<String> getNombresCompletosDeResponsablesPorCarrera(String carrera) {
        return responsablePppDao.getNombresCompletosDeResponsablesPorCarrera(carrera);
    }

    @Override
    public Integer buscarResponsablePorCarrera(String nombreCarrera) {
        return responsablePppDao.buscarResponsablePorCarrera(nombreCarrera);
    }

    public Responsable_PPP findByCedulaUsuario(String cedulaUsuario) {
        return responsablePppDao.findByCedulaUsuario(cedulaUsuario);
    }


}
