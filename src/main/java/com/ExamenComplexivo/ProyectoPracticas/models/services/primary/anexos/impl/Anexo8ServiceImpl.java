package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.impl;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos.IAnexo8_InformeFDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo8;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.anexos.service.IAnexo8Service;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class Anexo8ServiceImpl extends GenericServiceImpl<Anexo8,Long> implements IAnexo8Service {
    @Autowired
    IAnexo8_InformeFDao anexo8Dao;

    @Override
    public CrudRepository<Anexo8, Long> getDao() {
        return anexo8Dao;
    }
}
