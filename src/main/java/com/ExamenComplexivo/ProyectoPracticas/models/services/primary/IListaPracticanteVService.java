package com.ExamenComplexivo.ProyectoPracticas.models.services.primary;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.lista_practicantes_view;

import java.util.List;

public interface IListaPracticanteVService {

	public List<lista_practicantes_view> findAll();

	public List<lista_practicantes_view> findbyconv(Long numconv);

	public List<lista_practicantes_view> findbypract(Long idpract);

	public List<lista_practicantes_view> findbyreal(Long idreal);
}
