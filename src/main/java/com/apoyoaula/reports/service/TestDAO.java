package com.apoyoaula.reports.service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import com.apoyoaula.reports.model.Parametros;
import com.apoyoaula.reports.repository.dao.ParametrosDao;
import com.apoyoaula.reports.repository.dao.ParametrosDaoImpl;
import com.apoyoaula.reports.util.PDFUtil;

public class TestDAO {
	public static void main(String[] args) {
		ParametrosDao parametros = new ParametrosDaoImpl();
        
        // obtener el producto con ID = 100
		Parametros p = parametros.readByFolioDocente("09S1000111");
        System.out.println(p);
        
     	p = parametros.readByFolioEscuela("09S10001");
     	System.out.println(p);  
	}
}
