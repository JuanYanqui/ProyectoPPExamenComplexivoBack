package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;


import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Rol;
import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepositoryDao extends JpaRepository<Usuario,Long> {

    public Usuario findByCedula(String cedula);

    public Usuario findByCorreo(String correo);
    
    Boolean existsByCedula (String cedula);

    Boolean existsByCorreo(String correo);
    
    //Metodos Query
 		@Query(value = "SELECT idusuario FROM usuarios WHERE cedula = ?",
 				nativeQuery = true
 				)
     List<Usuario> buscarUsuario(String cedula);

    @Query("select u.nombres ||' '|| u.apellidos as nombres, s.fechaEnvio, u.carrera from Usuario u join u.estudiantePracticante e join e.solicitudConvocatorias s join s.convocatoria c where c.idConvocatorias = :idConvocatoria")
    List<Usuario> findUsuariosPorConvocatoria(@Param("idConvocatoria") Long idConvocatoria);

    @Query("SELECT ur.rolNombre FROM Usuario u JOIN u.roles ur  WHERE u.correo = :correo")
    String findRolNombreByCorreo(@Param("correo") String correo);


    @Query(value = "SELECT * FROM usuarios usua " +
            "JOIN usuarioroles as usurol ON usua.idusuario = usurol.idusuario " +
            "JOIN roles rol ON usurol.idrol = rol.idrol " +
            "WHERE rol.idrol = ?1", nativeQuery = true)
    List<Usuario> findUsuariosByRolId(int rolId);


    @Query(value = "SELECT * FROM usuarios usua " +
            "JOIN usuarioroles as usurol ON usua.idusuario = usurol.idusuario " +
            "JOIN roles rol ON usurol.idrol = rol.idrol " +
            "WHERE rol.idrol = 6 ", nativeQuery = true)
    List<Usuario> findUsuariosByRolIdAcademico();

}
