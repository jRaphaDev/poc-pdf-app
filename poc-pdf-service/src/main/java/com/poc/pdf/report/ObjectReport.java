package com.poc.pdf.report;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

 
public class ObjectReport {
	
	private String path; 
	/*private static String EXPORT_PDF_WIN = "url_win";
	private static String EXPORT_PDF_GNU = "url_gnu";*/
	private static String EXPORT_PDF_IOS = "/Users/raphael/Documents/santander-poc/poc-pdf/";
		
	public ObjectReport() {
		System.out.println("*** getting the base_path ***");
		this.path = this.getClass().getResource("/com/poc/pdf/templates/").getPath();
	}
	
	public File print(String template, List<Object> objects) throws Exception {
		JasperReport report = null;
		JasperPrint print = null;
		try {

			report = JasperCompileManager.compileReport(this.getPath() + template + ".jrxml");
			print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(objects));

			JasperExportManager.exportReportToPdfFile(print, EXPORT_PDF_IOS + template+".pdf");
			
			File file = new File(EXPORT_PDF_IOS + template+".pdf");

			return file;
		} catch (Exception e) {
			throw e;
		}
				
	}

	public String getPath() {
		return this.path;
	}
}