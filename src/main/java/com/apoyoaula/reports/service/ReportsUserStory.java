package com.apoyoaula.reports.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.apoyoaula.reports.model.GrupoInfo;
import com.apoyoaula.reports.util.PDFUtil;
import com.google.gson.Gson;

public class ReportsUserStory {
	private static Properties properties;
	public ReportsUserStory(Properties properties){
		this.properties = properties;
	}
	
	public Map<String,String> generaReportesEscuela(String idEscuela) throws Exception {
		if(idEscuela == null) {
			throw new Exception("El identificador de la escuela no es valido");
		}
		
		Map<String,String> response = new HashMap<String,String>();
		
		ReportsService2 service = new ReportsService2();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
				
		service.represent("PDF", getJasperPath("09LR02"), getParameters("09LR02"), baos);

		byte[] file = baos.toByteArray();
		new PDFUtil().createPDFFile(file);
		response.put("09LR02.pdf", Base64.getEncoder().encodeToString(file));
		
		
		baos = new ByteArrayOutputStream();
			
		service.represent("XLS", getJasperPath("09LR02"), getParameters("09LR02"), baos);
		file = baos.toByteArray();
		new PDFUtil().createXLSFile(file);
		response.put("09LR02.xls", Base64.getEncoder().encodeToString(file));
		
		
		
		return response;
	}
	
	public Map<String,byte[]> generaReportesGrupo(String idGrupo){
		return null;
	}
	
	public Map<String,String> generaReportesEscuelaJson(String data) throws Exception {
		
		
		Map<String,String> response = new HashMap<String,String>();
		
		ReportsService2 service = new ReportsService2();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
				
		service.represent("PDF", getJasperPath("09LR02"), getParameters("09LR02"), baos);

		byte[] file = baos.toByteArray();
		new PDFUtil().createPDFFile(file);
		response.put("09LR02.pdf", Base64.getEncoder().encodeToString(file));
		
		
		baos = new ByteArrayOutputStream();
			
		service.represent("XLS", getJasperPath("09LR02"), getParameters("09LR02"), baos);
		file = baos.toByteArray();
		new PDFUtil().createXLSFile(file);
		response.put("09LR02.xls", Base64.getEncoder().encodeToString(file));
		
		
		
		return response;
	}
	
	public Map<String,String> generaReportesGrupoJson(String data){
		GrupoInfo grupoInfo = new Gson().fromJson(data, GrupoInfo.class);
		return null;
	}
	
	private String getJasperPath(String name) throws Exception {
		String response = "";
		switch(name) {
		  case "09LR00":
		    response = new StringBuilder(properties.getProperty("reports.templates.directory"))
		    			.append(File.separator).append("reportes/config/template/09LR00.jasper").toString();
		    break;
		  case "09LR02":
			  response = new StringBuilder(properties.getProperty("reports.templates.directory"))
  						.append(File.separator).append("reportes/config/template/09LR02.jasper").toString();
		    break;
		  case "09LR03":
			  response = new StringBuilder(properties.getProperty("reports.templates.directory"))
  						.append(File.separator).append("reportes/config/template/09LR03.jasper").toString();
		    break;
		  default:
		    throw new Exception("No existe este reporte");
		}
		return response;
	}
	
	private Map<String,Object> getParameters(String name) throws Exception {
		Map<String,Object> response = null;
		switch(name) {
		  case "09LR00":
		    response = new HashMap();
		    break;
		  case "09LR02":
			    response = new HashMap();
		    break;
		  case "09LR03":
			    response = new HashMap();
		    break;
		  default:
		    throw new Exception("No existe este reporte");
		}
		return response;
	}
}
