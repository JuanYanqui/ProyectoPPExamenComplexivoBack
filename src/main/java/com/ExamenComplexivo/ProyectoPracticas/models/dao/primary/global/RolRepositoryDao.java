package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.global;


import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositoryDao extends JpaRepository<Rol,Long> {

    @Query("SELECT r FROM Rol r WHERE r.rolNombre = ?1")
    Rol findbynombre (String nombre);


}
