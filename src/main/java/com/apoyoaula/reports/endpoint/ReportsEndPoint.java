package com.apoyoaula.reports.endpoint;

import static spark.Spark.port;
import static spark.Spark.post;

public class ReportsEndPoint {
	public static void main(String[] args) {
		port(4567);
		post("/reportes", (request, response) -> {
			System.out.println("Llegue...");
			System.out.println("Llegue...");
			return "{\"success\":false}";
		});
	}
}
