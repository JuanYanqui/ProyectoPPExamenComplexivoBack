package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;

import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IConvocatoriaDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convocatorias;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Solicitud_Practicas;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IConvocatoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ConvocatoriaServiceImp extends GenericServiceImpl<Convocatorias,Long> implements IConvocatoriaService {
     @Autowired
    IConvocatoriaDao convocatoriaDao;
    @Override
    public CrudRepository<Convocatorias, Long> getDao() {
        return convocatoriaDao;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Convocatorias guardarDocumento(byte[] documento) {
        Convocatorias convocatorias=new Convocatorias();
        return convocatoriaDao.save(convocatorias);
    }
    public Long findDocumentoIdByConvocatoriaId(Long id) {
        return convocatoriaDao.findDocumentoIdByConvocatoriaId(id);
    }

    @Override
    public List<Convocatorias> buscarConvocatoriasConPractica() {
        return convocatoriaDao.buscarConvocatoriasConPractica();
    }


    public List<Convocatorias> findByConvocatoriaporCarrera(String carrera) {
        return convocatoriaDao.findByConvocatoriaporCarrera(carrera);
    }
    public List<Convocatorias> findByConvocatoriaporSolicitudP(Long idSolicitudPracticas) {
        return convocatoriaDao.findByConvocatoriaporSolicitudP(idSolicitudPracticas);
    }

    public List<Convocatorias> buscarsoliporempresacovocatoria(Long idempresa) {
        return convocatoriaDao.buscarsoliporempresacovocatoria(idempresa);
    }

    public List<Convocatorias> buscarsoliporempresacovocatoriaconestadosolicitud(Long idempresa) {
        return convocatoriaDao.buscarsoliporempresacovocatoriaconestadosolicitud(idempresa);
    }

    public List<Convocatorias> findByConvocatoriaporCarreraPractica(String carrera) {
        return convocatoriaDao.findByConvocatoriaporCarreraPractica(carrera);
    }
    public List<Object[]> buscarConvocatoriasC() {
        return convocatoriaDao.buscarConvocatoriasC();
    }
    public List<Convocatorias> BuscarConvocatoriaporCarrera(String carrera) {
        return convocatoriaDao.BuscarConvocatoriaporCarrera(carrera);
    }
}
