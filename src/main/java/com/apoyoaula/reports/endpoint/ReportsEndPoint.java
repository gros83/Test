package com.apoyoaula.reports.endpoint;

import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.get;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.apoyoaula.reports.service.ReportsUserStory;
import com.google.gson.Gson;

public class ReportsEndPoint {
	private static Properties properties = new Properties();
	private static int port; 
	
	public static void main(String[] args) {
		port(port);
		
		get("/reportes/escuelas/:idEscuela", (request, response) -> {
			try {
				String idEscuela = request.params(":idEscuela");
				System.out.println(idEscuela);
				ReportsUserStory story =  new ReportsUserStory(properties);
				Map<String,String> reportes = story.generaReportesEscuela(idEscuela);
				
				return new Gson().toJson(reportes);
			}catch(Exception e) {
				e.printStackTrace();
				Map<String,Object> error = new HashMap<String,Object>();
				error.put("error", e.getMessage());
				return new Gson().toJson(error);
			}
			
		});
		
		get("/reportes/grupos/:idGrupo", (request, response) -> {
			String idGrupo = request.params(":idGrupo");
			System.out.println(idGrupo);
			System.out.println("Llegue...");
			return "{\"success\":false}";
		});
		
		post("/reportes/escuelas",(request, response) -> {
				System.out.println(request.body());
				return "{\"success\":false}";
		});
		
		post("/reportes/grupos",(request, response) -> {
			try {
				String data = request.body();
				System.out.println(data);
				ReportsUserStory story =  new ReportsUserStory(properties);
				Map<String,String> reportes = story.generaReportesGrupoJson(data);
				
				return new Gson().toJson(reportes);
			}catch(Exception e) {
				e.printStackTrace();
				Map<String,Object> error = new HashMap<String,Object>();
				error.put("error", e.getMessage());
				return new Gson().toJson(error);
			}
	});
	}
	
	static {
		try {
			properties.load(ReportsEndPoint.class.getClassLoader().getResourceAsStream("reportes.properties"));
			
			port = Integer.parseInt(properties.getProperty("reports.port", "4567"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
