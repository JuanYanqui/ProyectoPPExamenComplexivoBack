package com.ExamenComplexivo.ProyectoPracticas.models.dao.primary.anexos;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.anexos.Anexo1;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
@EnableJpaRepositories
public interface IAnexo1Dao extends CrudRepository<Anexo1, Long> {

}
