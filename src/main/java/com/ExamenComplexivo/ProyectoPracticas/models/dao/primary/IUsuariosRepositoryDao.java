package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IUsuariosRepositoryDao extends CrudRepository<Usuario,Long> {

    public Usuario findByUsername(String username);

    public Usuario findByCorreo(String correo);
    
    Boolean existsByUsername(String username);

    Boolean existsByCorreo(String correo);
    
    //Metodos Query
 		@Query(value = "SELECT * FROM usuarios WHERE username = ?",
 				nativeQuery = true
 				)
     List<Usuario> buscarUsername(String username);
    
}
