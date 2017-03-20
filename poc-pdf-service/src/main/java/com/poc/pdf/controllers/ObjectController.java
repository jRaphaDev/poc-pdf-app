package com.poc.pdf.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.poc.pdf.services.ObjectService;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/service-pdf")
public class ObjectController {

	private ObjectService objectService;

	@Autowired
	public void setPersonService(ObjectService objectService) {
		this.objectService = objectService;
	}

	@POST
	@Path("/{template}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response print(@PathParam("template") String template, List<Object> objects) {
		try {
			
			File file = objectService.print(template, objects);
			FileInputStream fileInputStream = new FileInputStream(file);
			
			ResponseBuilder response = Response.ok(fileInputStream);
			response.type(MediaType.APPLICATION_OCTET_STREAM);
			response.header("Content-Disposition",  "filename="+file.getName());
			
	        return response.build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

}
