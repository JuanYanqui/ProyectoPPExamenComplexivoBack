package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.impl;


import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.RolRepositoryDao;
import com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global.UsuariosRepositoryDao;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Rol;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.UsuarioPrincipal;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services.IUsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//Este va ser el servicio principal del login.
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class IUsuarioServiceImpl implements IUsuarioService {

    private final UsuariosRepositoryDao usuariosDao;
    private final RolRepositoryDao rolRepositoryDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Rol saveRole(Rol rol) {
        log.info("Guardado nuevo rol {} en la BD", rol.getRolNombre());
        return rolRepositoryDao.save(rol);
    }

    @Override
    public void addRoleToUser(Usuario usuario) {
        log.info("Añadido rol {} a usuario {}", usuario.getRoles(), usuario.getCedula());
        usuariosDao.save(usuario);
    }


    @Override
    public Usuario findbyCedula(String cedula) {
        return usuariosDao.findByCedula(cedula);
    }

    @Override
    public List<Usuario> getUsusarios() {
        log.info("Recorrido de todos los usuarios");
        return usuariosDao.findAll();
    } 

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        //Usuario user = usuariosDao.findByCedula(cedula);
        Usuario user = usuariosDao.findByCorreo(correo);
        if (user == null){
            log.error("Ususario no esta en la base de datos..");
            throw new UsernameNotFoundException("Ususario no esta en la base de datos..");
        } else {
            log.info("Usuarion en la base de datos: {}", correo);
        }
        return UsuarioPrincipal.build(user);
    }
    
    //Metodos generados-------------------------------------------------------------------

    // EXTRA LOS DATOS DE USUARIO
    public List<Usuario> findAllByName (String cedula){
        List<Usuario> estadosRespuesta= new ArrayList<>();
        List<Usuario> user = usuariosDao.findAll();
        for (int i=0; i<user.size(); i++) {
            if (user.get(i).getCedula().toString() == cedula) {
                estadosRespuesta.add(user.get(i));
            }
        }
        return estadosRespuesta;
    }


    @Override
    public List<Usuario> findAllUsuario() {
        return (List<Usuario>) usuariosDao.findAll();
    }

    @Override
    @Transactional (readOnly= true)
    public Usuario findByIdUsuario(Long id) {
        return usuariosDao.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> buscarUsuario(String cedula) {
        return usuariosDao.buscarUsuario(cedula);
    }

    //Implementación de los nuevos metodos del grupo de josé..
    @Override
    public Usuario findById(Long id) {
        // TODO Auto-generated method stub
        return usuariosDao.findById(id).orElse(null);
    }

    public Usuario buscarPorCorreo(String correo) {
        return usuariosDao.findByCorreo(correo);
    }

    public List<Usuario> findUsuariosPorConvocatoria(Long idConvocatoria) {
        return usuariosDao.findUsuariosPorConvocatoria(idConvocatoria);
    }

    public String getRolNombreByCorreo(String correo) {
        return usuariosDao.findRolNombreByCorreo(correo);
    }


    public List<Usuario> getUsuariosByRolId(int rolId) {
        return usuariosDao.findUsuariosByRolId(rolId);
    }

    public List<Usuario> getUsuariosByRolIdAcademico() {
        return usuariosDao.findUsuariosByRolIdAcademico();
    }


    public boolean resetPassword(String cedula, String newPassword) {
        Usuario usuario = usuariosDao.findByCedula(cedula);
        if (usuario != null) {
            String encodedPassword = passwordEncoder.encode(newPassword);
            usuario.setContrasenia(encodedPassword);
            usuariosDao.save(usuario);
            return true;
        }
        return false;
    }

    public List<Object[]> findUsuariosPorTutorEmpresarial(Long idUsuario) {
        return usuariosDao.findUsuariosPorTutorEmpresarial(idUsuario);
    }
    public List<Object[]> buscarEstudiantesAxresponsable(Long idusuario) {
        return usuariosDao.buscarEstudiantesAxresponsable(idusuario);
    }
    public List<Object[]> buscarTutoresC() {
        return usuariosDao.buscarTutoresC();
    }

    @Override
    public List<Object[]> getUsuariosBytutoracademico(Long idUsuario) {
        return usuariosDao.getUsuariosBytutoracademico(idUsuario);
}


}
