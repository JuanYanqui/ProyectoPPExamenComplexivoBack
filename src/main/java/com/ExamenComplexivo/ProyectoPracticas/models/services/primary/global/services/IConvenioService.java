package com.ExamenComplexivo.ProyectoPracticas.models.services.primary.global.services;

import com.ExamenComplexivo.ProyectoPracticas.models.entity.primary.Convenio;
import com.ExamenComplexivo.ProyectoPracticas.models.services.primary.generic.IGenericService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IConvenioService extends IGenericService<Convenio,Long> {

    //Guardamos el documento de convenio
    //public Convenio guardarDocumento(byte[] documento);

}
