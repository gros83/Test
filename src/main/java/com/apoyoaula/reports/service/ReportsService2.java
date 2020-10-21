package com.apoyoaula.reports.service;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.apoyoaula.reports.impl.JasperImpl;
import com.apoyoaula.reports.impl.JasperImpl2;

public class ReportsService2 {
	public String represent(Map<String, Object> inputParameters, OutputStream out) throws Exception {
		
		if(!validate(out))
			throw new Exception("Missing output file. Output file must be specified");
		String alias = null;
		
		JasperImpl2 service = new JasperImpl2();
			
			if (inputParameters == null) 
				inputParameters = new HashMap<>();

			// Aqui agregar mas parametros que se necesten
			inputParameters.putAll(new HashMap());
			String ubicacionJasper = "/opt/apoyo/reportes/config/template/09LR02.jasper";
			service.toPdf(new File(ubicacionJasper), out, inputParameters);
			
			String nombreDelpdf = "reporte.pdf";
			alias = nombreDelpdf;
		
		return alias;
	}
	
	private boolean validate(InputStream document) {
		
		return document != null;
	}
	
	private boolean validate(OutputStream out) {
		
		return out != null;
	}
}