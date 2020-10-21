package com.apoyoaula.reports.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFUtil {
	public void createPDFFile(byte[] pdfFile) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("/opt/apoyo/reportes/files/ejemplo.pdf");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			fos.write(pdfFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createXLSFile(byte[] pdfFile) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("/opt/apoyo/reportes/files/ejemplo.xls");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			fos.write(pdfFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
