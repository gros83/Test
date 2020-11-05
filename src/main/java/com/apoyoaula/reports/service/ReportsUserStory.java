package com.apoyoaula.reports.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.apoyoaula.reports.model.Docente;
import com.apoyoaula.reports.model.Parametros;
import com.apoyoaula.reports.repository.dao.DocenteDao;
import com.apoyoaula.reports.repository.dao.DocenteDaoImpl;
import com.apoyoaula.reports.util.PDFUtil;
import com.google.gson.Gson;

public class ReportsUserStory {
	private static Properties properties;
	
	DocenteDao docente = new DocenteDaoImpl();
	private static final String LECTURA = "Lectura";
	private static final String MATEMATICAS = "Matematicas";
	
	public ReportsUserStory(Properties properties){
		this.properties = properties;
	}
	
	public Map<String,String> generaReportesEscuela(String idEscuela) throws Exception {
		if(idEscuela == null) {
			throw new Exception("Folio invalido");
		}
		
		boolean isEscuela = this.isEscuela(idEscuela);
		System.out.println("isEscuela:"+ isEscuela);
		
		Docente d = null;
		if(isEscuela) {
			d = docente.readByFolioEscuela(idEscuela);
		}else {
			d = docente.readByFolioDocente(idEscuela);
		}
		
		System.out.println(d.toString());
		
		String identificadorDeReportes = this.obtenNivelYGrupo(isEscuela, d);
		System.out.println(identificadorDeReportes);
		
		Integer codNivel = this.getCodNivel(d);
		
		Map<String,Object> parametros = this.getParameters(d,LECTURA,codNivel);
		System.out.println(parametros);
		
		Map<String,String> response = new HashMap<String,String>();
		
		ReportsService2 service = new ReportsService2();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
				
		service.represent("PDF", getJasperPath("08LR03"), parametros, baos);

		byte[] file = baos.toByteArray();
		new PDFUtil().createPDFFile(file,"08LR03.pdf");
		response.put("08LR03.pdf", Base64.getEncoder().encodeToString(file));
		
		baos = new ByteArrayOutputStream();
				
		service.represent("PDF", getJasperPath("09LR02"), getParameters("09LR02"), baos);

		file = baos.toByteArray();
		new PDFUtil().createPDFFile(file,"09LR02.pdf");
		response.put("09LR02.pdf", Base64.getEncoder().encodeToString(file));
		
		
		baos = new ByteArrayOutputStream();
			
		service.represent("XLS", getJasperPath("09LR02"), getParameters("09LR02"), baos);
		file = baos.toByteArray();
		new PDFUtil().createXLSFile(file,"09LR02.xls");
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
		new PDFUtil().createPDFFile(file, "09LR02.pdf");
		response.put("09LR02.pdf", Base64.getEncoder().encodeToString(file));
		
		
		baos = new ByteArrayOutputStream();
			
		service.represent("XLS", getJasperPath("09LR02"), getParameters("09LR02"), baos);
		file = baos.toByteArray();
		new PDFUtil().createXLSFile(file, "09LR02.xls");
		response.put("09LR02.xls", Base64.getEncoder().encodeToString(file));
		
		
		
		return response;
	}
	
	public Map<String,String> generaReportesGrupoJson(String data){
		Parametros grupoInfo = new Gson().fromJson(data, Parametros.class);
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
		  case "08LR03":
			  response = new StringBuilder(properties.getProperty("reports.templates.directory"))
  						.append(File.separator).append("reportes/config/template/08LR03.jasper").toString();
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
		  case "08LR03":
			    response = new HashMap();
		    break;
		  default:
		    throw new Exception("No existe este reporte");
		}
		return response;
	}
	
	private String obtenBaseNombreReportes(Parametros p) {
		System.out.println(p.getIdNivel());
		return null;
	}
	
	private boolean isEscuela(String value) throws Exception {
		int length = value.length();
		if(length == 8 || length == 10){
			if(length == 8) {
				return true;
			}else {
				return false;
			}
		}else{
			throw new Exception("Folio invalido");
		}
	}
	
	private String obtenNivelYGrupo(boolean isEscuela, Docente d){
		String response = "";
		if(isEscuela){
			response = d.getIdNivel();
		}else{
			response = d.getIdNivel() + d.getGradoDoc();
		}
		return response;
	}
	
	private Map<String,Object>getParameters(Docente d, String asignatura, Integer cod_nivel){
		Map<String,Object> response = new HashMap<String,Object>();
		response.put("Pcct", d.getCct());
		response.put("Pturno", d.getTurno().toUpperCase());
		response.put("Pcod_nivel", cod_nivel); // No se que va aqui
		response.put("Pgrupo", d.getGrupoDoc());
		response.put("Pasignatura", asignatura); //No se que va
		response.put("Pentidad", d.getEntidad());
		response.put("Pentidad", d.getNomEsc());
		return response;
	}
	
	private Integer getCodNivel(Docente d) throws Exception {
		String identificador = d.getIdNivel().toUpperCase() + d.getGradoDoc();
		Integer response = 0;
		switch (identificador) {
		case "P1":
			response = 1;
			break;
		case "P2":
			response = 2;
			break;
		case "P3":
			response = 3;
			break;
		case "P4":
			response = 4;
			break;
		case "P5":
			response = 5;
			break;
		case "P6":
			response = 6;
			break;
		case "S1":
			response = 7;
			break;
		case "S2":
			response = 8;
			break;
		case "S3":
			response = 9;
			break;
		default:
			throw new Exception("No fué posible calcular el codigo de nivel con los datos proporcionados");
		}
		return response;
	}
	
	private String getNameReports() {
		return null;
	}
}
