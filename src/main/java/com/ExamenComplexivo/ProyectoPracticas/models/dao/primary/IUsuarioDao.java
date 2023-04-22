package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

	public Usuario findByUsername(String cedula);
}
