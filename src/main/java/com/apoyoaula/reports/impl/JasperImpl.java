package com.apoyoaula.reports.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class JasperImpl{
	public void toPdf(InputStream xml, File template, OutputStream out, Map<String, Object> parameters) throws Exception {
		execute(xml, template, out, new JRPdfExporter(), parameters);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void execute(InputStream xml, File template, OutputStream out, Exporter exporter, Map<String, Object> parameters) throws Exception {
		Map<String, Object> params = new HashMap<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		dbf.setIgnoringComments(true);
		dbf.setNamespaceAware(true);
		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document document = builder.parse(xml);

		
		params.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);
		if(parameters != null)
			parameters.forEach((k, v) -> {
				params.put(k, v);
			});
		JasperPrint jasperPrint = JasperFillManager.fillReport(new FileInputStream(template), params);
		
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
		exporter.exportReport();
	}

}
