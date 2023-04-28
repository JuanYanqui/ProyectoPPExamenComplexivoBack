package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.impl;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo5Dao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo5;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo5Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Anexo5ServiceImpl extends GenericServiceImpl<Anexo5,Long> implements IAnexo5Service {
    @Autowired
    IAnexo5Dao anexo5Dao;

    @Override
    public CrudRepository<Anexo5, Long> getDao() {
        return anexo5Dao;
    }
}
