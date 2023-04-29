package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.IUserDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.GenericServiceImpl;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp extends GenericServiceImpl<Usuario,Long> implements IUserService {
    @Autowired
    IUserDao userDao;
    @Override
    public CrudRepository<Usuario, Long> getDao() {
        return userDao;
    }
}
