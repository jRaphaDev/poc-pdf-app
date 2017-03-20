package com.poc.pdf.services;

import java.io.File;
import java.util.List;


public interface ObjectService {
	
    File print(String template, List<Object> objects) throws Exception;
  
}
