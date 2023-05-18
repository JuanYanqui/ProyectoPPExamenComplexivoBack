package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Rol;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface IUsuarioService extends UserDetailsService{

    //Usuario saveUser(Usuario usuarios);
    
    Rol saveRole(Rol rol);

    void addRoleToUser(Usuario usuario);

    Usuario findbyCedula(String cedula);

    List<Usuario>getUsusarios();
    
    public List<Usuario> findAllUsuario();
	
	List<Usuario> buscarUsuario(String cedula);

    public Usuario findById(Long id);

    public Usuario findByIdUsuario(Long id);

    Usuario buscarPorCorreo(String correo);

    List<Usuario> findUsuariosPorConvocatoria(Long idConvocatoria);

    String getRolNombreByCorreo(String correo);

    List<Usuario> getUsuariosByRolId(int rolId);

    List<Usuario> getUsuariosByRolIdAcademico();

    boolean resetPassword(String cedula, String newPassword);

    List<Object[]> findUsuariosPorTutorEmpresarial(Long idUsuario);
    List<Object[]> buscarEstudiantesAxresponsable(Long idusuario);
    List<Object[]> buscarTutoresC();
    List<Object[]> getUsuariosBytutoracademico(Long idUsuario);
}
