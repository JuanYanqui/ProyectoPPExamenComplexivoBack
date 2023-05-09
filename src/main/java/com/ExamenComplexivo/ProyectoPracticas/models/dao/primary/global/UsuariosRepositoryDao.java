package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;


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
    
   

}
