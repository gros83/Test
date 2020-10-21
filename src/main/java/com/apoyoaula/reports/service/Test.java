package com.apoyoaula.reports.service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import com.apoyoaula.reports.util.PDFUtil;

public class Test {
	public static void main(String[] args) {
		System.out.println("Prueba");
		ReportsService2 service = new ReportsService2();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		HashMap inputParameters = new HashMap<String,Object>();
		try {
			service.represent(inputParameters, baos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] file = baos.toByteArray();
    	//new PDFUtil().createPDFFile(file);
		new PDFUtil().createXLSFile(file);
		System.out.println("Termina");
	}
}
