package com.apoyoaula.reports.service;

import java.util.Map;
import java.util.Properties;

public class ReportsUserStory {
	private static Properties properties;
	public ReportsUserStory(Properties properties){
		this.properties = properties;
	}
	public Map<String,byte[]> generaReportesEscuela(String idEscuela) throws Exception {
		if(idEscuela == null) {
			throw new Exception("El identificador de la escuela no es valido");
		}
		
		
		return null;
	}
	
	public Map<String,byte[]> generaReportesGrupo(String idGrupo){
		return null;
	}
}
