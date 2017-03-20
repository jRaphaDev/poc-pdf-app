package com.poc.pdf.services;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poc.pdf.report.ObjectReport;

@Service
public class ObjectServiceImpl implements ObjectService {
	
	private ObjectReport objectReport;
	
	public ObjectServiceImpl() {
		objectReport = new ObjectReport();
	}

	@Override
	public File print(String template, List<Object> objects) throws Exception {
		return objectReport.print(template, objects);
	}

}
